package br.com.fiap.sigint.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.time.DateUtils;

public class CartaoCreateUpdateDTO {
    
    // private Long cartao;
    private BigDecimal limiteCartao;
    private String senha;
    // private Date expiredDate;
    private int matriculaAluno;

    public Long getCartao() {
        Random rand = new Random();
        int prefix = 99;
        long x = (long)(rand.nextDouble()*100000000000000L);
        String s = String.valueOf(prefix) + String.format("%014d", x);
        Long cartao = Long.valueOf(s);
        return cartao;
    }

    public BigDecimal getLimite() {
        return limiteCartao;
    }
    public void setLimite(BigDecimal limite) {
        this.limiteCartao = limite;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public Date getExpiredDate() {
        Date data = new Date();
        data = DateUtils.addYears(data, 3);
        Timestamp ts = new Timestamp(data.getTime());
        Date expiredDate = ts;
        return expiredDate;
    }    

    public int getMatricula() {
        return matriculaAluno;
    }
    public void setMatricula(int matricula) {
        this.matriculaAluno = matricula;
    }
}
