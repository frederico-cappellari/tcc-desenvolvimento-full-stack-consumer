package br.com.gestaofinanceira.domain.notafiscal.service;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.gestaofinanceira.domain.notafiscal.dto.NfeResponseDTO;
import br.com.gestaofinanceira.infra.tokennfe.BearerTokenFilter;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/nfe") // parte final do caminho do endpoint
@RegisterRestClient(configKey = "serpro-api")
@RegisterProvider(BearerTokenFilter.class)
public interface NFeRestClient {

    
    @GET
    @Path("/{chaveNfe}")
    @Produces(MediaType.APPLICATION_JSON)
    NfeResponseDTO consultarNfe(@jakarta.ws.rs.PathParam("chaveNfe") String chaveNfe);

}
