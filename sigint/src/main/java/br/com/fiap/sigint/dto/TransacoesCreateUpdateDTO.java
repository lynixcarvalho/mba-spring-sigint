package br.com.fiap.sigint.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class TransacoesCreateUpdateDTO {
    
    private BigDecimal valorOperacao;
    private Long numeroCartao;
    
    public BigDecimal getValor() {
        return valorOperacao;
    }
    public void setValor(BigDecimal valor) {
        this.valorOperacao = valor;
    }
    public Long getCartao() {
        return numeroCartao;
    }
    public void setCartao(Long cartao) {
        this.numeroCartao = cartao;
    }
    public Date getData() {
        Date dt = new Date();
        Timestamp ts = new Timestamp(dt.getTime());
        Date dataOperacao = ts;
        return dataOperacao;
    }
            
}
