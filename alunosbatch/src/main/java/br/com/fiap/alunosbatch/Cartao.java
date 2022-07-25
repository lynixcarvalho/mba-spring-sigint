package br.com.fiap.alunosbatch;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class Cartao {

    private Long cartao;
    private BigDecimal limite;
    private String senha;
    private Date createdDate;
    private Date expiredDate;
    private Date cancelDate;
    private int alunoId;

    public Cartao() {
    }

    public Cartao(Long cartao, Date data, Integer alunoId) {
        this.cartao = cartao;
        this.limite = new BigDecimal(1200.00);
        this.senha  = "12345";
        Calendar calendar = Calendar.getInstance();            
        this.createdDate =  new Timestamp(calendar.getTimeInMillis());
        this.expiredDate = data;
        this.cancelDate = data;
        this.alunoId = alunoId;
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


    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Date getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }

    public int getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }

}
