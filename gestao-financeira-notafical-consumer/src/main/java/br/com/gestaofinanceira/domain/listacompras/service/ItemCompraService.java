package br.com.gestaofinanceira.domain.listacompras.service;

import java.util.List;

import br.com.gestaofinanceira.domain.listacompras.model.ItemCompraEntity;
import br.com.gestaofinanceira.domain.listacompras.repository.ItemCompraRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ItemCompraService {

    @Inject
    ItemCompraRepository itemCompraRepository;

    public List<ItemCompraEntity> listarPorUsuario(Long idUsuario) {
        return itemCompraRepository.listarPorUsuario(idUsuario);
    }

    @Transactional
    public void deleteItemCompra(ItemCompraEntity itemCompra) {
        if (itemCompra != null) {
            itemCompraRepository.delete(itemCompra);
        }
    }


}
