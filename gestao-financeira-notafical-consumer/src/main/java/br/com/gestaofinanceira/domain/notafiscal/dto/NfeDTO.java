package br.com.gestaofinanceira.domain.notafiscal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NfeDTO {

    public InfNFeDTO infNFe;

    @Override
    public String toString() {
        return "NfeDTO{" + "infNFe=" + infNFe + '}';
    }

}
