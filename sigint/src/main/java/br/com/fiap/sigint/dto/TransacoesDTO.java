package br.com.fiap.sigint.dto;

import java.math.BigDecimal;
import br.com.fiap.sigint.entity.TransacoesEntity;

public class TransacoesDTO {

    private int id;
    private BigDecimal valor;
    
    public TransacoesDTO() {
    }


    public TransacoesDTO(int id, BigDecimal valor) {
        this.id = id;
        this.valor = valor;
    }

    public TransacoesDTO(TransacoesEntity entity){
        this.valor = entity.getValor();
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

    
    
}
