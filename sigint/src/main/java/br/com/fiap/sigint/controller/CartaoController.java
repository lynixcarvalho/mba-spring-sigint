package br.com.fiap.sigint.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.sigint.dto.CartaoCreateUpdateDTO;
import br.com.fiap.sigint.dto.CartaoDTO;
import br.com.fiap.sigint.service.CartaoService;

@RestController
@RequestMapping("cartoes")
public class CartaoController {

    private CartaoService cartaoService;

    public CartaoController(CartaoService cartaoService) {
        this.cartaoService = cartaoService;
    }

    @GetMapping
    public List<CartaoDTO> listCartoes() {
        return cartaoService.listAll();
    }

    @GetMapping("{id}")
    public CartaoDTO getById(@PathVariable int id) {
        return cartaoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CartaoDTO insert(
            @RequestBody CartaoCreateUpdateDTO cartaoCreateUpdateDTO) {
        return cartaoService.create(cartaoCreateUpdateDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        cartaoService.delete(id);
    }

}
