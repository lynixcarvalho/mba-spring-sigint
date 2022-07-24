package br.com.fiap.sigint.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import br.com.fiap.sigint.dto.AlunosDTO;
import br.com.fiap.sigint.service.AlunosService;

@RestController
@RequestMapping("turma")
public class TurmaController {

    private AlunosService alunosService;

    public TurmaController(AlunosService alunosService) {
        this.alunosService = alunosService;
    }

    @GetMapping("{turma}")
    public List<AlunosDTO> getByTurma(@PathVariable String turma) {
        return alunosService.findByTurma(turma);
    }
    
}