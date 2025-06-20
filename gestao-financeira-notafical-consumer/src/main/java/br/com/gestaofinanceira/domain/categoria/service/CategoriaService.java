package br.com.gestaofinanceira.domain.categoria.service;

import br.com.gestaofinanceira.domain.categoria.model.CategoriaEntity;
import br.com.gestaofinanceira.domain.categoria.repository.CategoriaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CategoriaService {

    @Inject
    CategoriaRepository categoriaRepository;

    public CategoriaEntity buscaPorDescricao(String descricao) {
        return categoriaRepository.buscaPorDescricao(descricao);
    }

    @Transactional
    public void salvar(CategoriaEntity categoria) {
        categoriaRepository.persistAndFlush(categoria);
    }
}
