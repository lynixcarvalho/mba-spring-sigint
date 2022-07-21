package br.com.fiap.sigint.dto;

import java.math.BigDecimal;

import br.com.fiap.sigint.entity.CartaoEntity;

public class TransacoesCreateUpdateDTO {
    
    private BigDecimal valor;
    private CartaoEntity cartao;

    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    public CartaoEntity getCartao() {
        return cartao;
    }
    public void setCartao(CartaoEntity cartao) {
        this.cartao = cartao;
    }
        
}
