package br.com.fiap.sigint.service;

import java.util.List;

import br.com.fiap.sigint.dto.AlunosCreateUpdateDTO;
import br.com.fiap.sigint.dto.AlunosDTO;

public interface AlunosService {

    // CRUD
    List<AlunosDTO> listAll(String name);
    AlunosDTO findById(int id);
    AlunosDTO create(AlunosCreateUpdateDTO alunosCreateUpdateDTO);
    AlunosDTO update(int id, AlunosCreateUpdateDTO alunosCreateUpdateDTO);
    // AlunosDTO updatePrice(int id, CryptoUsdValueDTO cryptoUsdValueDTO);
    void delete(int id);
    
}
