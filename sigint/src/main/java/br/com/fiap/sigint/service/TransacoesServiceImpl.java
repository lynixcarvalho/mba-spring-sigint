package br.com.fiap.sigint.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.sigint.dto.TransacoesCartaoDTO;
import br.com.fiap.sigint.dto.TransacoesCreateUpdateDTO;
import br.com.fiap.sigint.dto.TransacoesDTO;
import br.com.fiap.sigint.entity.CartaoEntity;
import br.com.fiap.sigint.entity.TransacoesEntity;
import br.com.fiap.sigint.repository.CartaoRepository;
import br.com.fiap.sigint.repository.TransacoesRepository;

@Service
public class TransacoesServiceImpl implements TransacoesService {

    private TransacoesRepository transacoesRepository;
    private CartaoRepository cartaoRepository;

    public TransacoesServiceImpl(TransacoesRepository transacoesRepository, CartaoRepository cartaoRepository) {
        this.transacoesRepository = transacoesRepository;
        this.cartaoRepository = cartaoRepository;
    }

    @Override
    public List<TransacoesCartaoDTO> listAll() {
        List<TransacoesEntity> entityList;
        entityList = transacoesRepository.findAll();
        return entityList
                .stream()
                .map(entity -> new TransacoesCartaoDTO(entity))
                .collect(Collectors.toList());
    }

    @Override
    public List<TransacoesCartaoDTO> findByCartao(Long cartao) {
        List<TransacoesEntity> entity = transacoesRepository.findByCartao(cartao);
        if (entity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return null;
                    // entity
                    // .stream()
                    // .map(entity -> new TransacoesCartaoDTO(entity))
                    // .collect(Collectors.toList());
        }
    }

    @Override
    public TransacoesCartaoDTO findById(int id) {
        TransacoesEntity entity = transacoesRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new TransacoesCartaoDTO(entity);
    }

    @Override
    public TransacoesDTO create(TransacoesCreateUpdateDTO transacoesCreateUpdateDTO) {
        CartaoEntity cartao = cartaoRepository.findByCartao(transacoesCreateUpdateDTO.getCartao());
        
        TransacoesEntity transacao = new TransacoesEntity();
        transacao.setValor(transacoesCreateUpdateDTO.getValor());
        transacao.setCartao(cartao);
        transacao.setCreatedDate(transacoesCreateUpdateDTO.getData());

        TransacoesEntity savedTransacao = transacoesRepository.save(transacao);

        return new TransacoesDTO(savedTransacao);
    }

    @Override
    public void delete(int id) {
        TransacoesEntity entity = transacoesRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        transacoesRepository.delete(entity);                

    }

}
