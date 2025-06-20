package br.com.gestaofinanceira.domain.transacaofinanceira.repository;

import br.com.gestaofinanceira.domain.transacaofinanceira.model.TransacaoFinanceiraEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TransacaoFinanceiraRepository implements PanacheRepository<TransacaoFinanceiraEntity> {

}
