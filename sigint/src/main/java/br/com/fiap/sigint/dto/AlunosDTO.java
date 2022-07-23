package br.com.fiap.sigint.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.fiap.sigint.entity.AlunosEntity;

public class AlunosDTO {
    
    private int matricula;
    private String nome;
    private String turma;
    private List<CartaoAlunoDTO> cartao;

    public AlunosDTO() {
    }

    public AlunosDTO(String nome, String turma) {
        this.nome = nome;
        this.turma = turma;
    }

    public AlunosDTO(AlunosEntity entity) {
        this.matricula = entity.getMatricula();
        this.nome = entity.getNome();
        this.turma = entity.getTurma();
        this.cartao = entity.getCartao().stream().map(ent -> new CartaoAlunoDTO(ent)).collect(Collectors.toList());
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public List<CartaoAlunoDTO> getCartao() {
        return cartao;
    }

    public void setCartao(List<CartaoAlunoDTO> cartao) {
        this.cartao = cartao;
    }

}
