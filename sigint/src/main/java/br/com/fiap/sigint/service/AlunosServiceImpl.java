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
public class AlunosServiceImpl implements AlunosService{

    private AlunosRepository AlunosRepository;

    public AlunosServiceImpl(AlunosRepository AlunosRepository){
        this.AlunosRepository = AlunosRepository;
    }

    @Override
    public List<AlunosDTO> listAll(String name) {
        List<AlunosEntity> alunosEntityList;
        if(name == null){
            alunosEntityList = AlunosRepository.findAll();
        } else {
            alunosEntityList = AlunosRepository.findAllByNameContaining(name);
        }
        return alunosEntityList
                .stream()
                .map(entity -> new AlunosDTO(entity))
                .collect(Collectors.toList());
    }

    @Override
    public AlunosDTO findById(int id) {
        AlunosEntity AlunosEntity = AlunosRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new AlunosDTO(AlunosEntity);
    }

    @Override
    public AlunosDTO create(AlunosCreateUpdateDTO alunosCreateUpdateDTO) {
        AlunosEntity entity = new AlunosEntity();

        entity.setName(alunosCreateUpdateDTO.getName());
        entity.setMatricula(alunosCreateUpdateDTO.getMatricula());
        entity.setTurma(alunosCreateUpdateDTO.getTurma());

        AlunosEntity savedEntity = AlunosRepository.save(entity);
        return new AlunosDTO(savedEntity);
    }

    @Override
    public AlunosDTO update(int id, AlunosCreateUpdateDTO alunosCreateUpdateDTO) {
        AlunosEntity entity = AlunosRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        entity.setName(alunosCreateUpdateDTO.getName());
        entity.setMatricula(alunosCreateUpdateDTO.getMatricula());
        entity.setTurma(alunosCreateUpdateDTO.getTurma());

        AlunosEntity savedEntity = AlunosRepository.save(entity);
        return new AlunosDTO(savedEntity);
    }

    // @Override
    // public AlunosDTO updatePrice(int id, AlunosUsdValueDTO AlunosUsdValueDTO) {
    //     AlunosEntity entity = AlunosRepository.findById(id)
    //             .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    //     entity.setUsdValue(AlunosUsdValueDTO.getUsdValue());

    //     AlunosEntity savedEntity = AlunosRepository.save(entity);
    //     return new AlunosDTO(savedEntity);
    // }

    @Override
    public void delete(int id) {
        AlunosEntity entity = AlunosRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        AlunosRepository.delete(entity);
    }

    
}
