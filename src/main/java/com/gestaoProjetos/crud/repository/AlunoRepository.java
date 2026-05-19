package com.gestaoProjetos.crud.repository;

import com.gestaoProjetos.crud.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
