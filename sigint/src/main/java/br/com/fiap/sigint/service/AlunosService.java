package br.com.fiap.sigint.service;

import java.util.List;

import br.com.fiap.sigint.dto.AlunosCreateUpdateDTO;
import br.com.fiap.sigint.dto.AlunosDTO;

public interface AlunosService {

    List<AlunosDTO> listAll(String name);
    AlunosDTO findById(int id);
    AlunosDTO findByMatricula(int matricula);
    List<AlunosDTO> findByTurma(String turma);
    AlunosDTO create(AlunosCreateUpdateDTO alunosCreateUpdateDTO);
    AlunosDTO update(int matricula, AlunosCreateUpdateDTO alunosCreateUpdateDTO);
    void delete(int id);
}
