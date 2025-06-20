package br.com.gestaofinanceira.domain.notafiscal.repository;

import br.com.gestaofinanceira.domain.notafiscal.model.NotaFiscalEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NotaFiscalRepository  implements PanacheRepository<NotaFiscalEntity> {

    public NotaFiscalEntity findByChaveDeAcesso(String chaveDeAcesso) {
        return find("chaveDeAcesso", chaveDeAcesso).firstResult();
    }

}
