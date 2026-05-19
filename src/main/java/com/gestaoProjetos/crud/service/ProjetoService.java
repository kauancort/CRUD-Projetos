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

    public List<Projeto> listarTodos() {

        return projetoRepository.findAll();
    }

    public Projeto buscarPorId(Long id) {
        return projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("id nao encontrado"));
    }

    public Projeto salvar(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    public Projeto atualizar(Long id, Projeto projeto) {
        Projeto att = buscarPorId(id);
        att.setNome(projeto.getNome());
        att.setDescricao(projeto.getDescricao());
        return projetoRepository.save(att);
    }

    public void deletar(Long id) {
        projetoRepository.deleteById(id);
    }
}
