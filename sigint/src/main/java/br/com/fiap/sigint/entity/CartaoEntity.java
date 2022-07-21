package br.com.fiap.sigint.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "CARTAO")
@EntityListeners(AuditingEntityListener.class)
public class CartaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private Long cardNumber;

    @Column
    private BigDecimal limite;

    @Column
    private String senha;

    @Column(nullable = false, updatable = false)
    @CreatedDate
    private Date createdDate;

    @Column(nullable = true, updatable = false)
    private Date cancelDate;

    @Column(nullable = false, updatable = false)
    private Date expiredDate;

    @ManyToOne()
    @JoinColumn(name = "alunos_id")
    private AlunosEntity alunos;

    @Column
    @OneToMany(mappedBy="cartao", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private Set<TransacoesEntity> transacoes = new LinkedHashSet<TransacoesEntity>();

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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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

    public AlunosEntity getAlunos() {
        return alunos;
    }

    public void setAlunos(AlunosEntity alunos) {
        this.alunos = alunos;
    }

    public Set<TransacoesEntity> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(Set<TransacoesEntity> transacoes) {
        this.transacoes = transacoes;
    }
}
