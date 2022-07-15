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
    
    private AlunosService AlunosService;

    public AlunosController(AlunosService AlunosService) {
        this.AlunosService = AlunosService;
    }

    @GetMapping
    public List<AlunosDTO> listAlunoss(
        @RequestParam(required = false) String name
        ) {
            return AlunosService.listAll(name);
    }

    @GetMapping("{id}")
    public AlunosDTO getById(@PathVariable int id) {
        return AlunosService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlunosDTO insert(
        @RequestBody AlunosCreateUpdateDTO createUpdateAlunosDTO
        ) {
            return AlunosService.create(createUpdateAlunosDTO);
    }

    @PutMapping("{id}")
    public AlunosDTO update(
        @RequestBody AlunosCreateUpdateDTO createUpdateAlunosDTO,
        @PathVariable int id
        ) {
            return AlunosService.update(id, createUpdateAlunosDTO);
    }

    // @PatchMapping("{id}")
    // public AlunosDTO updateUsdValue(
    //     @PathVariable int id,
    //     @RequestBody AlunosUsdValueDTO AlunosUsdValueDTO
    //     ) {
    //         return AlunosService.updatePrice(id, AlunosUsdValueDTO);
    // }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        AlunosService.delete(id);
    }


}
