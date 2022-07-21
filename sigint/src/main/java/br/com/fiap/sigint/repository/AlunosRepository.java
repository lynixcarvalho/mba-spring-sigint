package br.com.fiap.sigint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import br.com.fiap.sigint.entity.AlunosEntity;

public interface AlunosRepository extends JpaRepository<AlunosEntity, Integer> {

    List<AlunosEntity> findAllByNameContaining(String name);

    //@Query("from ALUNOS a where a.matricula = :matricula")
    @Query(
        value = "SELECT * FROM ALUNOS a WHERE a.matricula = ?1", 
        nativeQuery = true)
    AlunosEntity findByMatricula(int matricula); 

    //@Query("from ALUNOS a where a.turma = :turma")
    @Query(
        value = "SELECT * FROM ALUNOS a WHERE a.turma = ?1", 
        nativeQuery = true)
    public List<AlunosEntity> findByTurma(String turma); 

}
