package br.com.gestaofinanceira.infra.tokennfe;

import java.io.IOException;

import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;
import jakarta.ws.rs.client.ClientResponseContext;
import jakarta.ws.rs.client.ClientResponseFilter;
import jakarta.ws.rs.ext.Provider;

@Provider
public class BearerTokenFilter implements ClientRequestFilter, ClientResponseFilter {

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        requestContext.getHeaders().add("Authorization", "Bearer Bearer 06aef429-a981-3ec5-a1f8-71d38d86481e");
        // Log the request URI for debugging purposes
        System.out.println("Request URI: " + requestContext.getUri());
    }

    @Override
    public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
        // Log the body of the response for debugging purposes
       // responseContext.getEntityStream().transferTo(System.out);
        System.out.println("Response Status: " + responseContext.getStatus());
    }
}