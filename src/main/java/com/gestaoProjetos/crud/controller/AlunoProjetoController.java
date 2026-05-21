package com.gestaoProjetos.crud.controller;

import com.gestaoProjetos.crud.entities.Aluno_Projeto;
import com.gestaoProjetos.crud.service.AlunoProjetoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno-projetos")
public class AlunoProjetoController {

    AlunoProjetoService aps;

    public AlunoProjetoController(AlunoProjetoService aps) {
        this.aps = aps;
    }

    @PostMapping
    public List<Aluno_Projeto> create(Aluno_Projeto ap) {
        return aps.create(ap);
    }

    @GetMapping
    public List<Aluno_Projeto> listAll() {
        return aps.listAll();
    }

    @GetMapping("/{id}")
    public Aluno_Projeto searchbyId(@PathVariable Long id) {
        return aps.searchById(id);

    }

    @PutMapping("/{id}")
    public List<Aluno_Projeto> update(@PathVariable Long id, @RequestBody Aluno_Projeto ap) {
        return aps.update(id, ap);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        aps.delete(id);
    }
}
