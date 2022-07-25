package br.com.fiap.sigint.dto;

import java.math.BigDecimal;
import java.util.Date;
import br.com.fiap.sigint.entity.TransacoesEntity;


public class TransacoesCartaoDTO {
    
    private int id;
    private BigDecimal valor;
    private Date data;
    private Long cartao;

    public TransacoesCartaoDTO() {
    }


    public TransacoesCartaoDTO(BigDecimal valor) {
        this.valor = valor;
    }

    public TransacoesCartaoDTO(TransacoesEntity entity){
        this.id = entity.getId();
        this.valor = entity.getValor();
        this.data = entity.getCreatedDate();
        this.cartao = entity.getCartao().getCartao();
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

    public Long getCartao() {
        return cartao;
    }


    public void setCartao(Long cartao) {
        this.cartao = cartao;
    }
    
}
