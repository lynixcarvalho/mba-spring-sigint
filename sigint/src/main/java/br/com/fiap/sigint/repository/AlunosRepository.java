package br.com.fiap.sigint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.sigint.entity.AlunosEntity;

public interface AlunosRepository extends JpaRepository<AlunosEntity, Integer> {

    @Query(
        value = "SELECT * FROM ALUNOS a WHERE a.nome LIKE ?1", 
        nativeQuery = true)
        List<AlunosEntity> findByNome(String nome); 

    @Query(
        value = "SELECT * FROM ALUNOS a WHERE a.matricula = ?1", 
        nativeQuery = true)
    AlunosEntity findByMatricula(int matricula); 

    @Query(
        value = "SELECT * FROM ALUNOS a WHERE a.turma = ?1", 
        nativeQuery = true)
    public List<AlunosEntity> findByTurma(String turma); 

}
