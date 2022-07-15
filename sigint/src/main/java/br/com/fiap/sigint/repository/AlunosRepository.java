package br.com.fiap.sigint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.sigint.entity.AlunosEntity;

public interface AlunosRepository extends JpaRepository<AlunosEntity, Integer> {

    List<AlunosEntity> findAllByNameContaining(String name);

    @Query("from AlunosEntity c where c.name like :name")
    List<AlunosEntity> buscarAlunossPorNome(String name);
}
