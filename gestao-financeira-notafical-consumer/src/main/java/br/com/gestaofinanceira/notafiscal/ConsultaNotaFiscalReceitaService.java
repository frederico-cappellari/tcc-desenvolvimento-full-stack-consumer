package br.com.gestaofinanceira.notafiscal;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import io.vertx.core.json.JsonObject;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ConsultaNotaFiscalReceitaService {

    @Incoming("nota-fiscal")
    public void consume(JsonObject message) {
        System.out.println("Received message: " + message.toString());
    }

}
