package br.com.fiap.sigint.dto;

import java.math.BigDecimal;

public class TransacoesCreateUpdateDTO {
    
    private BigDecimal valor;
    private Long cartao;

    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Long getCartao() {
        return cartao;
    }
    public void setCartao(Long cartao) {
        this.cartao = cartao;
    }
            
}
