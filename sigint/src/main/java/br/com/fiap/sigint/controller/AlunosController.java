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
            @RequestParam(required = false) String nome) {
        return alunosService.listAll(nome);
    }

    @GetMapping("{matricula}")
    public AlunosDTO getByMatricula(@PathVariable int matricula) {
        return alunosService.findByMatricula(matricula);
    }

    @GetMapping("{matricula}/turma/{turma}")
    public List<AlunosDTO> getByTurma(@PathVariable String turma) {
        return alunosService.findByTurma(turma);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlunosDTO insert(
            @RequestBody AlunosCreateUpdateDTO createUpdateAlunosDTO) {
        return alunosService.create(createUpdateAlunosDTO);
    }

    @PutMapping("{matricula}")
    public AlunosDTO update(
            @RequestBody AlunosCreateUpdateDTO createUpdateAlunosDTO,
            @PathVariable int matricula) {
        return alunosService.update(matricula, createUpdateAlunosDTO);
    }

    @DeleteMapping("{matricula}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int matricula) {
        alunosService.delete(matricula);
    }

}
