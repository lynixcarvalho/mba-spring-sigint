package br.com.fiap.sigint.dto;

public class AlunosCreateUpdateDTO {

    private String name;
    private int matricula;
    private String turma;

    public String getName() {
        return name;
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
    
}
