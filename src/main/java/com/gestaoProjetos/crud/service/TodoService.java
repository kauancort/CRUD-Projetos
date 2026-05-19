package com.gestaoProjetos.crud.service;

import com.gestaoProjetos.crud.entities.Todo;
import com.gestaoProjetos.crud.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepo;

    public List<Todo> listAll() {
        Sort sort = Sort.by("prioridade").descending()
                .and(Sort.by("titulo")).ascending();
        return todoRepo.findAll(sort);
    }

    public Todo buscarPorId(Long id) {
        return todoRepo.findById(id).orElseThrow(() -> new RuntimeException("id invalido"));
    }

    public List<Todo> Salvar(Todo todo) {
        todoRepo.save(todo);

        return listAll();
    }

    public List<Todo> atualizar(Long id, Todo todo) {
        Todo att = buscarPorId(id);
        att.setDescricao(todo.getDescricao());
        att.setPrioridade(todo.getPrioridade());
        todoRepo.save(att);
        return listAll();
    }

    public void deletar(Long id) {
        todoRepo.deleteById(id);
    }



}
