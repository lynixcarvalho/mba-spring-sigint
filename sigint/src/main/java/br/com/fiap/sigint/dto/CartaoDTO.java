package br.com.fiap.sigint.dto;

import java.math.BigDecimal;
import java.util.Date;

import br.com.fiap.sigint.entity.CartaoEntity;

public class CartaoDTO {

    private Long cartao;
    private BigDecimal limite;
    private String senha;
    private Date emissao;
    private Date validade;

    public CartaoDTO() {
    }

    public CartaoDTO(BigDecimal limite, String senha) {
        this.limite = limite;
        this.senha = senha;
    }

    public CartaoDTO(CartaoEntity entity) {
        this.cartao = entity.getCartao();
        this.limite = entity.getLimite();
        this.senha = entity.getSenha();
        this.emissao = entity.getCreatedDate();
        this.validade = entity.getExpiredDate();
    }

    public Long getCartao() {
        return cartao;
    }

    public void setCartao(Long cartao) {
        this.cartao = cartao;
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

    public Date getEmissao() {
        return emissao;
    }

    public void setEmissao(Date emissao) {
        this.emissao = emissao;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }
}
