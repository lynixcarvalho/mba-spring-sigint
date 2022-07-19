package br.com.fiap.sigint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.sigint.entity.TransacoesEntity;

public interface TransacoesRepository extends JpaRepository<TransacoesEntity, Integer>{
    
}
