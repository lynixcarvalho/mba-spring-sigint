package br.com.fiap.sigint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.sigint.entity.TransacoesEntity;

public interface TransacoesRepository extends JpaRepository<TransacoesEntity, Integer>{
    
    @Query(
        value = "SELECT * FROM TRANSACOES t WHERE t.cartao = ?1", 
        nativeQuery = true)
    public List<TransacoesEntity> findByCartao(Long cartao); 

}
