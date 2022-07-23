package br.com.fiap.sigint.dto;

import java.math.BigDecimal;
import java.util.Date;

import br.com.fiap.sigint.entity.TransacoesEntity;

public class TransacoesDTO {

    private int id;
    private BigDecimal valor;
    private Date data;

    public TransacoesDTO() {
    }


    public TransacoesDTO(int id, BigDecimal valor, Date data) {
        this.id = id;
        this.valor = valor;
        this.data = data;
    }

    public TransacoesDTO(TransacoesEntity entity){
        this.id = entity.getId();
        this.valor = entity.getValor();
        this.data = entity.getCreatedDate();
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public BigDecimal getValor() {
        return valor;
    }


    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }


    public void setData(Date data) {
        this.data = data;
    }
    
}
