package br.com.fiap.sigint.dto;

import java.util.Set;

import br.com.fiap.sigint.entity.AlunosEntity;
import br.com.fiap.sigint.entity.CartaoEntity;

public class AlunosDTO {
    
    private int id;
    private String name;
    private int matricula;
    private String turma;
    private Set<CartaoEntity> cardNumber;

    public AlunosDTO() {
    }

    public AlunosDTO(int id, String name, int matricula, String turma) {
        this.id = id;
        this.name = name;
        this.matricula = matricula;
        this.turma = turma;
    }

    public AlunosDTO(AlunosEntity entity) {
        this.name = entity.getName();
        this.matricula = entity.getMatricula();
        this.turma = entity.getTurma();
        this.cardNumber = entity.getCartao();
    }

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
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public Set<CartaoEntity> getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Set<CartaoEntity> cardNumber) {
        this.cardNumber = cardNumber;
    }

}
