package br.com.fiap.sigint.dto;

import java.math.BigDecimal;

public class CartaoCreateUpdateDTO {
    
    private Long cardNumber;
    private BigDecimal limite;
    private String senha;
    
    public Long getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }
    public BigDecimal getLimite() {
        return limite;
    }
    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    
}
