package com.gestaoProjetos.crud.repository;

import com.gestaoProjetos.crud.entities.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

}
