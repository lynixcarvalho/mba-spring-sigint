package br.com.fiap.sigint.dto;

import java.math.BigDecimal;
//import java.util.Random;

import br.com.fiap.sigint.entity.AlunosEntity;
import br.com.fiap.sigint.entity.CartaoEntity;

public class CartaoDTO {

    private int id;
    private Long cardNumber;
    private BigDecimal limite;
    private String senha;
    //private AlunosEntity aluno;

    public CartaoDTO() {
    }

    public CartaoDTO(int id, Long cardNumber, BigDecimal limite, String senha) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.limite = limite;
        this.senha = senha;
    }

    public CartaoDTO(CartaoEntity entity){
        this.cardNumber = entity.getCardNumber();
        this.limite = entity.getLimite();
        this.senha = entity.getSenha();
        //this.aluno = entity.getAlunos();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getCardNumber() {
        // Random rand = new Random();
        // int prefix = 99;
        // long x = (long)(rand.nextDouble()*100000000000000L);
        // String s = String.valueOf(prefix) + String.format("%014d", x);
        // cardNumber = Long.valueOf(s);
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimit(BigDecimal limite) {
        this.limite = limite;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // public AlunosEntity getAluno() {
    //     return aluno;
    // }

    // public void setAluno(AlunosEntity aluno) {
    //     this.aluno = aluno;
    // }
}
