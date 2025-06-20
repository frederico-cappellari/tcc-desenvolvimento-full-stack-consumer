package br.com.gestaofinanceira.domain.usuario.service;

import br.com.gestaofinanceira.domain.usuario.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UsuarioService {

    @Inject
    UsuarioRepository usuarioRepository;

}
