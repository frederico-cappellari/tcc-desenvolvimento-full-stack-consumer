package br.com.gestaofinanceira.domain.notafiscal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItensNFeDTO {

    public Long nItem;

    public ProdutoDTO prod;

    @Override
    public String toString() {
        return "ItensNFeDTO{" + "nItem=" + nItem + ", prod=" + prod +'}';
    }

}
