package com.gestaoProjetos.crud.controller;


import com.gestaoProjetos.crud.service.ProjetoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Projeto")
public class ProjetoController {

    private ProjetoService projetoService;

    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }


}
