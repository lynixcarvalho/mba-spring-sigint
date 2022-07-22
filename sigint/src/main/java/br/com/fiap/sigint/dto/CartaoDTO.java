package br.com.fiap.sigint.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import br.com.fiap.sigint.entity.AlunosEntity;
import br.com.fiap.sigint.entity.CartaoEntity;
import br.com.fiap.sigint.entity.TransacoesEntity;

public class CartaoDTO {

    private int id;
    private Long cardNumber;
    private BigDecimal limite;
    private String senha;
    private AlunosEntity alunos;
    private Set<TransacoesEntity> transacoes;
    private Date cancelDate;
    private Date expiredDate;

    public CartaoDTO() {
    }

    public CartaoDTO(int id, Long cardNumber, BigDecimal limite, String senha, Date cancelDate, Date expiredDate) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.limite = limite;
        this.senha = senha;
        this.cancelDate = cancelDate;
        this.expiredDate = expiredDate;
    }

    public CartaoDTO(CartaoEntity entity) {
        this.cardNumber = entity.getCardNumber();
        this.limite = entity.getLimite();
        this.senha = entity.getSenha();
        this.cancelDate = entity.getCancelDate();
        this.expiredDate = entity.getExpiredDate();
        this.alunos = entity.getAlunos();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public AlunosEntity getAluno() {
        return alunos;
    }

    public void setAluno(AlunosEntity aluno) {
        this.alunos = aluno;
    }

    public Set<TransacoesEntity> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(Set<TransacoesEntity> transacoes) {
        this.transacoes = transacoes;
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
}
