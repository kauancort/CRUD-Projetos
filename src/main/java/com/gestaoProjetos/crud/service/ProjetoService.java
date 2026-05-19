package com.gestaoProjetos.crud.service;


import com.gestaoProjetos.crud.entities.Projeto;
import com.gestaoProjetos.crud.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Projeto> create(Projeto projeto) {
        projetoRepository.save(projeto);
        return listAll();
    }

    public List<Projeto> listAll() {

        return projetoRepository.findAll();
    }

    public Projeto searchById(Long id) {
        return projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("id nao encontrado"));
    }

    public List<Projeto> update(Long id, Projeto projeto) {
        Projeto att = searchById(id);
        att.setNome(projeto.getNome());
        att.setDescricao(projeto.getDescricao());
        projetoRepository.save(att);
        return listAll();
    }

    public void delete(Long id) {
        projetoRepository.deleteById(id);
    }
}
