package com.gestaoProjetos.crud.controller;

import com.gestaoProjetos.crud.entities.Aluno;
import com.gestaoProjetos.crud.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos") //padrao rest usar plural e minusculo
public class AlunoController {

    //pra executar, tem que ter o service:
    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    //tera todas as operações que tem no service:

    //expondo as operações para criar endpoints ao serviço web

    @PostMapping
    public List<Aluno> create(@RequestBody Aluno aluno) {
        return alunoService.create(aluno);
    }

    @GetMapping
    public List<Aluno> listAll() {
        return alunoService.listAll();
    }

    @GetMapping("/{id}") //tem dois get, ent precisa mudar a rota para nao dar conflito
    public Aluno searchById(@PathVariable Long id) {
        return alunoService.searchById(id);
    }

    @PutMapping("/{id}")
    public List<Aluno> update(@PathVariable Long id, @RequestBody Aluno aluno) {
        return alunoService.update(id, aluno);
    }

    @DeleteMapping("/{id}")
    public List<Aluno> delete(@PathVariable Long id) {
        return alunoService.delete(id);
    }

}
