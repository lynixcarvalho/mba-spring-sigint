package br.com.fiap.sigint.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.sigint.dto.TransacoesCartaoDTO;
import br.com.fiap.sigint.service.TransacoesService;

@RestController
@RequestMapping("extrato")
public class ExtratoController {
    
    private TransacoesService transacoesService;

    public ExtratoController(TransacoesService transacoesService) {
        this.transacoesService = transacoesService;
    }

    @GetMapping("{cartao}")
    public List<TransacoesCartaoDTO> getByCartao(@PathVariable Long cartao) {
        return transacoesService.findByCartao(cartao);
    }

}
