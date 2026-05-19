package com.gestaoProjetos.crud.service;

import com.gestaoProjetos.crud.entities.Aluno_Projeto;
import com.gestaoProjetos.crud.repository.AlunoProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoProjetoService {

    @Autowired
    AlunoProjetoRepository alunoProjetoRepo;

    public List<Aluno_Projeto> create(Aluno_Projeto al) {
        alunoProjetoRepo.save(al);
        return listAll();
    }

    public List<Aluno_Projeto> listAll() {
        return alunoProjetoRepo.findAll();
    }

    public Aluno_Projeto searchById(Long id) {
        return alunoProjetoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("não encontrado"));
    }

    public Aluno_Projeto update(Long id, Aluno_Projeto ap) {
        Aluno_Projeto att = searchById(id);
        att.setAluno(ap.getAluno());
        att.setProjeto(ap.getProjeto());
        return alunoProjetoRepo.save(att);
    }

    public void delete(Long id) {
        alunoProjetoRepo.deleteById(id);
    }
}
