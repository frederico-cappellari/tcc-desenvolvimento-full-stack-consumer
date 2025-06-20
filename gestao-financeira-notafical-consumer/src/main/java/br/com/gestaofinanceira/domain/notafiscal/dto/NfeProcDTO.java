package br.com.gestaofinanceira.domain.notafiscal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NfeProcDTO {

    public NfeDTO NFe;

    @Override
    public String toString() {
        return "NfeProcDTO{" + "NFe='" + NFe + '\'' +'}';
    }
}
