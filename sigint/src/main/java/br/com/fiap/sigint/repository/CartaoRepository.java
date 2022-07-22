package br.com.fiap.sigint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.sigint.entity.CartaoEntity;

public interface CartaoRepository extends JpaRepository<CartaoEntity, Integer> {

    //@Query("select c from CARTAO c where c.card_number = :card_number")
    @Query(
        value = "SELECT * FROM CARTAO c WHERE c.card_number = ?1", 
        nativeQuery = true)
    public CartaoEntity findByCardNumber(Long cardNumber);

}
