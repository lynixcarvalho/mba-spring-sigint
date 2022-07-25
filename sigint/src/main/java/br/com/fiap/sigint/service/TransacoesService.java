package br.com.fiap.sigint.service;

import java.util.List;

import br.com.fiap.sigint.dto.TransacoesCartaoDTO;
import br.com.fiap.sigint.dto.TransacoesCreateUpdateDTO;
import br.com.fiap.sigint.dto.TransacoesDTO;

public interface TransacoesService {

    List<TransacoesCartaoDTO> listAll();

    TransacoesCartaoDTO findById(int id);

    List<TransacoesCartaoDTO> findByCartao(Long Cartao);

    TransacoesDTO create(TransacoesCreateUpdateDTO transacoesCreateUpdateDTO);

    void delete(int id);

}
