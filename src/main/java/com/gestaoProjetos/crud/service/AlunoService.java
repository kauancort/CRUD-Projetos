package com.gestaoProjetos.crud.service;

import com.gestaoProjetos.crud.entities.Aluno;
import com.gestaoProjetos.crud.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> create(Aluno aluno) {
        alunoRepository.save(aluno);
        return listAll();
    }

    public List<Aluno> listAll() {
        return alunoRepository.findAll();
    }

    public Aluno searchById(Long id) {
        return alunoRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Aluno nao encontrado"));
    }

    public List<Aluno> update(Long id, Aluno aluno) {
        Aluno existente = searchById(id);
        existente.setNome(aluno.getNome());
        existente.setEmail(aluno.getEmail());
        alunoRepository.save(existente);

        return listAll();
    }

    public List<Aluno> delete(Long id) {
        alunoRepository.deleteById(id);
        return listAll();
    }
}

