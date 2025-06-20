package br.com.gestaofinanceira.domain.notafiscal.service;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import io.vertx.core.json.JsonObject;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ConsomeFilaNotaFiscalService {

    @Inject
    NotaFiscalReceitaService notaFiscalReceitaService;

    @Incoming("nota-fiscal")
    @Transactional
    public void consume(JsonObject message) {
        System.out.println("Received message: " + message.toString());
        String chaveDeAcesso = message.getString("chaveDeAcesso");
        this.notaFiscalReceitaService.executa(chaveDeAcesso);
    }
}
