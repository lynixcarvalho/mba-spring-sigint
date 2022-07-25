package br.com.fiap.sigint.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.sigint.dto.TransacoesCartaoDTO;
import br.com.fiap.sigint.dto.TransacoesCreateUpdateDTO;
import br.com.fiap.sigint.dto.TransacoesDTO;
import br.com.fiap.sigint.service.TransacoesService;

@RestController
@RequestMapping("transacoes")
public class TransacoesController {

    private TransacoesService transacoesService;

    public TransacoesController(TransacoesService transacoesService) {
        this.transacoesService = transacoesService;
    }

    @GetMapping
    public List<TransacoesCartaoDTO> listTransacoes() {
        return transacoesService.listAll();
        
    }

    @GetMapping("{id}")
    public TransacoesCartaoDTO getById(@PathVariable int id) {
        return transacoesService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransacoesDTO create(
            @RequestBody TransacoesCreateUpdateDTO transacoesCreateUpdateDTO) {
        return transacoesService.create(transacoesCreateUpdateDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        transacoesService.delete(id);
    }
}
