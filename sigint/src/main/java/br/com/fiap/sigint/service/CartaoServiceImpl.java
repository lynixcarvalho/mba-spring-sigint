package br.com.fiap.sigint.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.sigint.dto.CartaoCreateUpdateDTO;
import br.com.fiap.sigint.dto.CartaoDTO;
import br.com.fiap.sigint.entity.CartaoEntity;
import br.com.fiap.sigint.repository.CartaoRepository;

@Service
public class CartaoServiceImpl implements CartaoService {

    private CartaoRepository cartaoRepository;

    public CartaoServiceImpl(CartaoRepository cartaoRepository) {
        this.cartaoRepository = cartaoRepository;
    }

    @Override
    public List<CartaoDTO> listAll() {
        List<CartaoEntity> cartaoEntityList;    
        cartaoEntityList = cartaoRepository.findAll();
        return cartaoEntityList
                .stream()
                .map(entity -> new CartaoDTO(entity))
                .collect(Collectors.toList());
    }

    @Override
    public CartaoDTO findById(int id) {
        CartaoEntity cartaoEntity = cartaoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new CartaoDTO(cartaoEntity);
    }

    // @Override
    // public CartaoDTO findCardByNumber(Long cardNumber) {
    //     CartaoEntity cartaoEntity = cartaoRepository.findByNumber(cardNumber);
    //     if (cartaoEntity == null) {
    //         throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    //     } else {
    //         return new CartaoDTO(cartaoEntity);
    //     }
    // }

    @Override
    public CartaoDTO create(CartaoCreateUpdateDTO cartaoCreateUpdateDTO) {
        CartaoEntity entity = new CartaoEntity();

        entity.setCardNumber(cartaoCreateUpdateDTO.getCardNumber());
        entity.setLimite(cartaoCreateUpdateDTO.getLimite());
        entity.setSenha(cartaoCreateUpdateDTO.getSenha());

        CartaoEntity savedEntity = cartaoRepository.save(entity);
        return new CartaoDTO(savedEntity);
    }

    @Override
    public void delete(int id) {
        CartaoEntity entity = cartaoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        cartaoRepository.delete(entity);
    }

}
