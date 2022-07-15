package br.com.fiap.sigint.dto;

import br.com.fiap.sigint.entity.AlunosEntity;

public class AlunosDTO {
    
    private int id;
    private String name;
    private int matricula;
    private String turma;

    public AlunosDTO() {
    }

    public AlunosDTO(int id, String name, int matricula, String turma) {
        this.id = id;
        this.name = name;
    }

    public AlunosDTO(AlunosEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.matricula = entity.getMatricula();
        this.turma = entity.getTurma();
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

}
