package br.com.fiap.sigint.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.sigint.dto.AlunosCreateUpdateDTO;
import br.com.fiap.sigint.dto.AlunosDTO;
import br.com.fiap.sigint.service.AlunosService;

@RestController
@RequestMapping("alunos")
public class AlunosController {

    private AlunosService alunosService;

    public AlunosController(AlunosService alunosService) {
        this.alunosService = alunosService;
    }

    @GetMapping
    public List<AlunosDTO> listAlunos(
            @RequestParam(required = false) String name) {
        return alunosService.listAll(name);
    }

    @GetMapping("{id}")
    public AlunosDTO getById(@PathVariable int id) {
        return alunosService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlunosDTO insert(
            @RequestBody AlunosCreateUpdateDTO createUpdateAlunosDTO) {
        return alunosService.create(createUpdateAlunosDTO);
    }

    @PutMapping("{id}")
    public AlunosDTO update(
            @RequestBody AlunosCreateUpdateDTO createUpdateAlunosDTO,
            @PathVariable int id) {
        return alunosService.update(id, createUpdateAlunosDTO);
    }

    // @PatchMapping("{id}")
    // public AlunosDTO updateUsdValue(
    // @PathVariable int id,
    // @RequestBody AlunosUsdValueDTO AlunosUsdValueDTO
    // ) {
    // return AlunosService.updatePrice(id, AlunosUsdValueDTO);
    // }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        alunosService.delete(id);
    }

}
