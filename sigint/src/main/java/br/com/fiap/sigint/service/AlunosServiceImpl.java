package br.com.fiap.sigint.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.sigint.dto.AlunosCreateUpdateDTO;
import br.com.fiap.sigint.dto.AlunosDTO;
import br.com.fiap.sigint.entity.AlunosEntity;
import br.com.fiap.sigint.repository.AlunosRepository;

@Service
public class AlunosServiceImpl implements AlunosService {

    private AlunosRepository alunosRepository;

    public AlunosServiceImpl(AlunosRepository alunosRepository) {
        this.alunosRepository = alunosRepository;
    }

    @Override
    public List<AlunosDTO> listAll(String nome) {
        List<AlunosEntity> alunosEntityList;
        if (nome == null) {
            alunosEntityList = alunosRepository.findAll();
        } else {
            alunosEntityList = alunosRepository.findByNome(nome);
        }
        return alunosEntityList
                .stream()
                .map(entity -> new AlunosDTO(entity))
                .collect(Collectors.toList());
    }

    @Override
    public List<AlunosDTO> findByTurma(String turma) {
        List<AlunosEntity> alunos = alunosRepository.findByTurma(turma);
        if (alunos == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return alunos.stream().map(entity -> new AlunosDTO(entity)).collect(Collectors.toList());
        }
    }

    @Override
    public AlunosDTO findByMatricula(int matricula) {
        AlunosEntity aluno = alunosRepository.findByMatricula(matricula);
        if (aluno == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return new AlunosDTO(aluno);
        }
    }

    @Override
    public AlunosDTO create(AlunosCreateUpdateDTO alunosCreateUpdateDTO) {
        AlunosEntity aluno = new AlunosEntity();

        aluno.setNome(alunosCreateUpdateDTO.getNome());
        aluno.setTurma(alunosCreateUpdateDTO.getTurma());

        AlunosEntity savedAluno = alunosRepository.save(aluno);
        return new AlunosDTO(savedAluno);
    }

    @Override
    public AlunosDTO update(int matricula, AlunosCreateUpdateDTO alunosCreateUpdateDTO) {
        AlunosEntity aluno = alunosRepository.findByMatricula(matricula);
        if (aluno == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            aluno.setNome(alunosCreateUpdateDTO.getNome());
            aluno.setTurma(alunosCreateUpdateDTO.getTurma());
    
            AlunosEntity savedAluno = alunosRepository.save(aluno);
            return new AlunosDTO(savedAluno);
        }
    }

    @Override
    public void delete(int matricula) {
        AlunosEntity aluno = alunosRepository.findByMatricula(matricula);
        if (aluno == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            alunosRepository.delete(aluno);
        }
    }

}
