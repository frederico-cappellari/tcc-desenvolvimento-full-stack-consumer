package br.com.gestaofinanceira.domain.notafiscal.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProdutoDTO {

    @JsonProperty("xProd")
    public String nome;

    @JsonProperty("vUnCom")
    public BigDecimal valorUnitario;

    @JsonProperty("qCom")
    public Long quantidade;

    @Override
    public String toString() {
        return "ProdutoDTO{" + "nome='" + nome + '\'' + ", valorUnitario=" + valorUnitario + ", quantidade=" + quantidade +'}';
    }

}
