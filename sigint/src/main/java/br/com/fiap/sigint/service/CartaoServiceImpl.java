package br.com.fiap.sigint.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.sigint.dto.CartaoCreateUpdateDTO;
import br.com.fiap.sigint.dto.CartaoDTO;
import br.com.fiap.sigint.entity.AlunosEntity;
import br.com.fiap.sigint.entity.CartaoEntity;
import br.com.fiap.sigint.repository.AlunosRepository;
import br.com.fiap.sigint.repository.CartaoRepository;

@Service
public class CartaoServiceImpl implements CartaoService {

    private CartaoRepository cartaoRepository;
    private AlunosRepository alunosRepository;

    public CartaoServiceImpl(CartaoRepository cartaoRepository, AlunosRepository alunosRepository) {
        this.cartaoRepository = cartaoRepository;
        this.alunosRepository = alunosRepository;
    }

    @Override
    public List<CartaoDTO> listAll() {
        List<CartaoEntity> cartaoList;
        cartaoList = cartaoRepository.findAll();
        return cartaoList
                .stream()
                .map(entity -> new CartaoDTO(entity))
                .collect(Collectors.toList());
    }

    @Override
    public CartaoDTO findByCartao(Long cartao) {
        CartaoEntity entity = cartaoRepository.findByCartao(cartao);
        if (entity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return new CartaoDTO(entity);
        }
    }

    @Override
    public CartaoDTO create(CartaoCreateUpdateDTO cartaoCreateUpdateDTO) {
        AlunosEntity aluno = alunosRepository.findByMatricula(cartaoCreateUpdateDTO.getMatricula());
        
        CartaoEntity cartao = new CartaoEntity();
        cartao.setCartao(cartaoCreateUpdateDTO.getCartao());
        cartao.setLimite(cartaoCreateUpdateDTO.getLimite());
        cartao.setSenha(cartaoCreateUpdateDTO.getSenha());
        cartao.setExpiredDate(cartaoCreateUpdateDTO.getExpiredDate());
        cartao.setAlunos(aluno);

        CartaoEntity savedCartao = cartaoRepository.save(cartao);
        
        return new CartaoDTO(savedCartao);
    }

    @Override
    public void delete(Long cartao) {
        CartaoEntity entity = cartaoRepository.findByCartao(cartao);
        if (entity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            cartaoRepository.delete(entity);
        }
    }

}
