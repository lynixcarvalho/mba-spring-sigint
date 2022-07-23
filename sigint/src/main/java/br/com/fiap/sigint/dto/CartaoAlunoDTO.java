package br.com.fiap.sigint.dto;

import java.math.BigDecimal;
import java.util.Date;

import br.com.fiap.sigint.entity.CartaoEntity;

public class CartaoAlunoDTO {

    private Long cartao;
    private BigDecimal limite;
    private String senha;
    private Date cancelDate;
    private Date expiredDate;
    private String nome;
    private int matricula;

    public CartaoAlunoDTO() {
    }

    public CartaoAlunoDTO(Long cartao, BigDecimal limite, String senha, Date cancelDate, Date expiredDate) {
        this.cartao = cartao;
        this.limite = limite;
        this.senha = senha;
        this.cancelDate = cancelDate;
        this.expiredDate = expiredDate;
    }

    public CartaoAlunoDTO(CartaoEntity entity) {
        this.cartao = entity.getCartao();
        this.limite = entity.getLimite();
        this.senha = entity.getSenha();
        this.cancelDate = entity.getCancelDate();
        this.expiredDate = entity.getExpiredDate();
        this.nome = entity.getAlunos().getNome();
        this.matricula = entity.getAlunos().getMatricula();
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

    public Date getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}
