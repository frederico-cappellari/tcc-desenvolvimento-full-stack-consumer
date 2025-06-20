package br.com.gestaofinanceira.domain.listacompras.repository;

import java.util.List;

import br.com.gestaofinanceira.domain.listacompras.model.ItemCompraEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ItemCompraRepository implements PanacheRepository<ItemCompraEntity> {

    public List<ItemCompraEntity> listarPorUsuario(Long usuarioId) {
        return find("usuario.id", usuarioId).list();
    } 
    
}