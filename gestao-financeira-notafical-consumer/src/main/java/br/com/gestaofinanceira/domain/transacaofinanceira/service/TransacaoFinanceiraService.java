package br.com.gestaofinanceira.domain.transacaofinanceira.service;

import br.com.gestaofinanceira.domain.categoria.model.CategoriaEntity;
import br.com.gestaofinanceira.domain.categoria.service.CategoriaService;
import br.com.gestaofinanceira.domain.notafiscal.dto.ProdutoDTO;
import br.com.gestaofinanceira.domain.notafiscal.model.NotaFiscalEntity;
import br.com.gestaofinanceira.domain.transacaofinanceira.model.TransacaoFinanceiraEntity;
import br.com.gestaofinanceira.domain.transacaofinanceira.repository.TransacaoFinanceiraRepository;
import br.com.gestaofinanceira.infra.enums.TipoTransacaoFinanceiraEnum;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class TransacaoFinanceiraService {

    @Inject
    TransacaoFinanceiraRepository transacaoFinanceiraRepository;

    @Inject
    CategoriaService categoriaService;

    @Transactional
    public void inserirTransacaoFinanceira(NotaFiscalEntity notaFiscal, ProdutoDTO produtoDTO) {
        TransacaoFinanceiraEntity transacaoFinanceira = new TransacaoFinanceiraEntity();
        transacaoFinanceira.setUsuario(notaFiscal.getUsuario());
        CategoriaEntity categoria = new CategoriaEntity();
        categoria.setDescricao("Nota Fiscal");
        System.out.println("Buscando categoria: " + categoria.getDescricao());
        CategoriaEntity categoriaExistente = this.categoriaService.buscaPorDescricao(categoria.getDescricao());
        if (categoriaExistente != null) {
            categoria = categoriaExistente;
        } else {
            System.out.println("Categoria não encontrada, criando nova categoria: " + categoria.getDescricao());
            this.categoriaService.salvar(categoria);
        }
        transacaoFinanceira.setCategoria(categoria);
        transacaoFinanceira.setData(notaFiscal.getData());
        transacaoFinanceira.setRecorrente(Boolean.FALSE);
        transacaoFinanceira.setTipo(TipoTransacaoFinanceiraEnum.DESPESA);
        transacaoFinanceira.setValor(produtoDTO.valorUnitario);
        transacaoFinanceira.setDescricao(produtoDTO.nome);
        this.transacaoFinanceiraRepository.persist(transacaoFinanceira);
        System.out.println("Transação financeira inserida: " + transacaoFinanceira.toString());
    }

}
