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

    public List<Aluno_Projeto> listarTodos() {
        return alunoProjetoRepo.findAll();
    }

    public Aluno_Projeto buscarPorId(Long id) {
        return alunoProjetoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("não encontrado"));
    }

    public Aluno_Projeto salvar(Aluno_Projeto alunoProjeto) {
        return alunoProjetoRepo.save(alunoProjeto);
    }

    public Aluno_Projeto atualizar(Long id, Aluno_Projeto ap) {
        Aluno_Projeto att = buscarPorId(id);
        att.setAluno(ap.getAluno());
        att.setProjeto(ap.getProjeto());
        return alunoProjetoRepo.save(att);
    }

    public void deletar(Long id) {
        alunoProjetoRepo.deleteById(id);
    }
}
