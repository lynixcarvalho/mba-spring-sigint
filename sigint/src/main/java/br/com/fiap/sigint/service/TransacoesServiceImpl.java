package br.com.fiap.sigint.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.sigint.dto.TransacoesCreateUpdateDTO;
import br.com.fiap.sigint.dto.TransacoesDTO;
import br.com.fiap.sigint.entity.TransacoesEntity;
import br.com.fiap.sigint.repository.TransacoesRepository;

@Service
public class TransacoesServiceImpl implements TransacoesService {

    private TransacoesRepository transacoesRepository;

    public TransacoesServiceImpl(TransacoesRepository transacoesRepository) {
        this.transacoesRepository = transacoesRepository;
    }

    @Override
    public List<TransacoesDTO> listAll() {
        List<TransacoesEntity> entityList;
        entityList = transacoesRepository.findAll();
        return entityList.stream().map(entity -> new TransacoesDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public TransacoesDTO findById(int id) {
        TransacoesEntity entity = transacoesRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new TransacoesDTO(entity);
    }

    @Override
    public TransacoesDTO create(TransacoesCreateUpdateDTO transacoesCreateUpdateDTO) {
        TransacoesEntity entity = new TransacoesEntity();

        entity.setValor(transacoesCreateUpdateDTO.getValor());

        TransacoesEntity savedEntity = transacoesRepository.save(entity);
        return new TransacoesDTO(savedEntity);
    }

    @Override
    public void delete(int id) {
        TransacoesEntity entity = transacoesRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        transacoesRepository.delete(entity);                

    }

}
