package com.gestaoProjetos.crud.repository;

import com.gestaoProjetos.crud.entities.Aluno_Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoProjetoRepository extends JpaRepository<Aluno_Projeto, Long> {

}
