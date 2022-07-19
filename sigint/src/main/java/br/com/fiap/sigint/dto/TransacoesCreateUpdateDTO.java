package br.com.fiap.sigint.dto;

import java.math.BigDecimal;

public class TransacoesCreateUpdateDTO {
    
    private BigDecimal valor;

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
        
}
