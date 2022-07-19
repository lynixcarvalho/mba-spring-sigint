package br.com.fiap.sigint.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;

import br.com.fiap.sigint.entity.CartaoEntity;

public interface CartaoRepository extends JpaRepository<CartaoEntity, Integer> {

    //List<CartaoEntity> findAllByNumber(Long cardNumber);

    // @Query("from CartaoEntity c where c.cardNumber like :cardNumber")
    // CartaoEntity findByNumber(Long cardNumber);
}
