package br.edu.ucsal.ms_alunos.controller;

import br.edu.ucsal.ms_alunos.dto.AlunoRequest;
import br.edu.ucsal.ms_alunos.entity.Aluno;
import br.edu.ucsal.ms_alunos.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @PostMapping
    public Aluno criar(@RequestBody AlunoRequest request) {
        return service.criar(request);
    }

    @GetMapping
    public List<Aluno> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Aluno buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PutMapping("/{id}/ativar")
    public Aluno ativar(@PathVariable Long id) {
        return service.ativar(id);
    }

    @PutMapping("/{id}/inativar")
    public Aluno inativar(@PathVariable Long id) {
        return service.inativar(id);
    }
}