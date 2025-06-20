package br.com.gestaofinanceira.domain.notafiscal.service;

import java.math.BigDecimal;
import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.gestaofinanceira.domain.listacompras.model.ItemCompraEntity;
import br.com.gestaofinanceira.domain.listacompras.service.ItemCompraService;
import br.com.gestaofinanceira.domain.notafiscal.dto.ItensNFeDTO;
import br.com.gestaofinanceira.domain.notafiscal.dto.NfeResponseDTO;
import br.com.gestaofinanceira.domain.notafiscal.dto.ProdutoDTO;
import br.com.gestaofinanceira.domain.notafiscal.model.NotaFiscalEntity;
import br.com.gestaofinanceira.domain.notafiscal.repository.NotaFiscalRepository;
import br.com.gestaofinanceira.domain.transacaofinanceira.service.TransacaoFinanceiraService;
import br.com.gestaofinanceira.infra.enums.SituacaoNotaFiscalEnum;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class NotaFiscalReceitaService {

    @Inject
    @RestClient
    NFeRestClient nfeClient;

    @Inject
    NotaFiscalRepository notaFiscalRepository;

    @Inject
    ItemCompraService itemCompraService;

    @Inject
    TransacaoFinanceiraService transacaoFinanceiraService;

    @Transactional
    public void executa(String chaveDeAcesso) {
        System.out.println("Executando serviço com chave: " + chaveDeAcesso);
        NotaFiscalEntity notaFiscal = notaFiscalRepository.findByChaveDeAcesso(chaveDeAcesso);
        if (chaveDeAcesso == null || !chaveDeAcesso.matches("^\\d{44}$") || notaFiscal == null) {
            notaFiscal.setSituacao(SituacaoNotaFiscalEnum.PROCESSADA_NAO_ENCONTRADA);
            notaFiscalRepository.persistAndFlush(notaFiscal);
            System.out.println("Nota fiscal não encontrada ou chave inválida: " + chaveDeAcesso);
            return;
        }
        try {
            NfeResponseDTO response = this.nfeClient.consultarNfe(chaveDeAcesso);
            BigDecimal valorTotal = BigDecimal.ZERO;
            List<ItemCompraEntity> listaDeCompras = itemCompraService.listarPorUsuario(notaFiscal.getUsuario().getId());
            notaFiscal.setPossuiItensNaoEncontradosNaLista(false);
            for (ItensNFeDTO itensNFeDTO : response.nfeProc.NFe.infNFe.det) {
                ProdutoDTO produtoDTO = itensNFeDTO.prod;
                for (int i = 0; i < produtoDTO.quantidade; i++) {
                    // Insere Transação Financeira
                    System.out.println("Inserindo transação financeira para o produto: " + produtoDTO.nome);
                    transacaoFinanceiraService.inserirTransacaoFinanceira(notaFiscal, produtoDTO);
                    valorTotal = valorTotal.add(produtoDTO.valorUnitario);
                }

                boolean itemEncontrado = false;
                for (ItemCompraEntity itemCompra : listaDeCompras) {
                    System.out.println("Verificando item de compra: " + itemCompra.getDescricao());
                    if (produtoDTO.nome.toLowerCase().contains(itemCompra.getDescricao().toLowerCase())) {
                        itemEncontrado = true;
                        itemCompraService.deleteItemCompra(itemCompra);
                        break;
                    }
                }

                if (!itemEncontrado) {
                    notaFiscal.setPossuiItensNaoEncontradosNaLista(true);
                    break;
                }
            }
            System.out.println("Persistindo nota fiscal com chave: " + chaveDeAcesso);
            notaFiscal.setSituacao(SituacaoNotaFiscalEnum.PROCESSADA);
            notaFiscal.setValorTotal(valorTotal);
            notaFiscalRepository.persistAndFlush(notaFiscal);
        }
        catch (Exception e) {
            notaFiscal.setSituacao(SituacaoNotaFiscalEnum.PROCESSADA_NAO_ENCONTRADA);
            notaFiscalRepository.persistAndFlush(notaFiscal);
            return;
        }

    }

}
