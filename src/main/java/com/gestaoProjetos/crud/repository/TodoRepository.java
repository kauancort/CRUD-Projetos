package com.gestaoProjetos.crud.repository;

import com.gestaoProjetos.crud.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
