package br.com.fiap.sigint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.sigint.entity.CartaoEntity;

public interface CartaoRepository extends JpaRepository<CartaoEntity, Integer> {

    @Query(
        value = "SELECT * FROM CARTAO c WHERE c.cartao = ?1", 
        nativeQuery = true)
    public CartaoEntity findByCartao(Long cartao);

    @Query(
        value = "SELECT * FROM CARTAO", 
        nativeQuery = true)
    public List<CartaoEntity> findByAll();

}
