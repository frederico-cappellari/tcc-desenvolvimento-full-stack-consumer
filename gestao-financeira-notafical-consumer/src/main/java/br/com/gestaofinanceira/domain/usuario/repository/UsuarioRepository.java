package br.com.gestaofinanceira.domain.usuario.repository;

import br.com.gestaofinanceira.domain.usuario.model.UsuarioEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<UsuarioEntity> {

}
