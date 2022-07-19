package br.com.fiap.sigint.service;

import java.util.List;

import br.com.fiap.sigint.dto.TransacoesCreateUpdateDTO;
import br.com.fiap.sigint.dto.TransacoesDTO;

public interface TransacoesService {

    List<TransacoesDTO> listAll();

    TransacoesDTO findById(int id);

    TransacoesDTO create(TransacoesCreateUpdateDTO transacoesCreateUpdateDTO);

    void delete(int id);

}
