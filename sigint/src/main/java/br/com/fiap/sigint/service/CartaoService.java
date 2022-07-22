package br.com.fiap.sigint.service;

import java.util.List;

import br.com.fiap.sigint.dto.CartaoCreateUpdateDTO;
import br.com.fiap.sigint.dto.CartaoDTO;

public interface CartaoService {

    List<CartaoDTO> listAll();
    CartaoDTO findByCartao(Long cartao);
    CartaoDTO create(CartaoCreateUpdateDTO cartaoCreateUpdateDTO);
    void delete(Long cartao);
}
