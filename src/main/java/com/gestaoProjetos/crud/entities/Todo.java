package com.gestaoProjetos.crud.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private String status = "pendente";
    private String prioridade;

    @ManyToOne
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "id_projeto")
    private Projeto projeto;

    public Todo() {  }

    public Todo(Long id, String titulo, String descricao, String status, Aluno aluno, Projeto projeto, String prioridade) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.aluno = aluno;
        this.projeto = projeto;
        this.prioridade = prioridade;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Aluno getAluno() { return aluno; }
    public void setAluno(Aluno aluno) { this.aluno = aluno; }

    public Projeto getProjeto() { return projeto; }
    public void setProjeto(Projeto projeto) { this.projeto = projeto; }

    public String getPrioridade() { return prioridade; }
    public void setPrioridade(String prioridade) { this.prioridade = prioridade; }

    public Long getId() { return id; }

}