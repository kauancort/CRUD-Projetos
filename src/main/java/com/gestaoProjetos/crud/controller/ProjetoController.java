package com.gestaoProjetos.crud.controller;


import com.gestaoProjetos.crud.entities.Projeto;
import com.gestaoProjetos.crud.service.ProjetoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Projeto")
public class ProjetoController {

    private ProjetoService projetoService;

    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @PostMapping
    public List<Projeto> create(@RequestBody Projeto projeto) {
        return projetoService.create(projeto);
    }

    @GetMapping
    public List<Projeto> listAll() {
        return projetoService.listAll();
    }

    @GetMapping("/{id}")
    public Projeto searchbyId(@PathVariable Long id) {
        return projetoService.searchById(id);

    }

    @PutMapping("/{id}")
    public List<Projeto> update(@PathVariable Long id, @RequestBody Projeto projeto) {
        return projetoService.update(id, projeto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        projetoService.delete(id);
    }

}
