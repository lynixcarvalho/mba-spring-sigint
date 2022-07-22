package br.com.fiap.sigint.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.time.DateUtils;

public class CartaoCreateUpdateDTO {
    
    private Long cardNumber;
    private BigDecimal limite;
    private String senha;
    private Date expiredDate;
    private int matricula;

    public Long getCardNumber() {
        Random rand = new Random();
        int prefix = 99;
        long x = (long)(rand.nextDouble()*100000000000000L);
        String s = String.valueOf(prefix) + String.format("%014d", x);
        cardNumber = Long.valueOf(s);
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
    public Date getExpiredDate() {
        Date data = new Date();
        data = DateUtils.addYears(data, 3);
        Timestamp ts = new Timestamp(data.getTime());
        expiredDate = ts;
        return expiredDate;
    }    

    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}
