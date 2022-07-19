package br.com.fiap.sigint.entity;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "TB_ALUNOS")
@EntityListeners(AuditingEntityListener.class)
public class AlunosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column(unique = true)
    private int matricula;

    @Column
    private String turma;

    // @Column
    // @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="alunos")
    // private Set<CartaoEntity> cartao = new LinkedHashSet<CartaoEntity>();

    @Column(nullable = false, updatable = false)
    @CreatedDate
    private Date createdDate;

    @Column(nullable = false, updatable = true)
    @LastModifiedDate
    private Date modifiedDate;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMatricula() {
        return this.matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getTurma() {
        return this.turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    // public Set<CartaoEntity> getCartao() {
    //     return cartao;
    // }

    // public void setCartao(Set<CartaoEntity> cartao) {
    //     this.cartao = cartao;
    // }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return this.modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

}