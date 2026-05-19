package com.gestaoProjetos.crud.controller;

import com.gestaoProjetos.crud.entities.Todo;
import com.gestaoProjetos.crud.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public List<Todo> create(@RequestBody Todo todo) {
        return todoService.create(todo);
    }

    @GetMapping
    public List<Todo> listAll() {
        return todoService.listAll();
    }

    @GetMapping("/{id}")
    public Todo searchbyId(@PathVariable Long id) {
        return todoService.searchById(id);

    }

    @PutMapping("/{id}")
    public List<Todo> update(@PathVariable Long id, @RequestBody Todo todo) {
        return todoService.update(id, todo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        todoService.delete(id);
    }
}
