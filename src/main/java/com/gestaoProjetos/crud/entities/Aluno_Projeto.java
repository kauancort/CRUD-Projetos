package com.gestaoProjetos.crud.entities;
import jakarta.persistence.*;

@Entity
@Table
public class Aluno_Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String funcao;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

    public Aluno_Projeto(Long id, Aluno aluno, Projeto projeto, String funcao) {
        this.id = id;
        this.aluno = aluno;
        this.projeto = projeto;
        this.funcao = funcao;
    }

    public Long getId() { return id; }

    public String getFuncao() { return funcao; }
    public void setFuncao(String funcao) { this.funcao = funcao; }

    public Aluno getAluno() { return aluno; }
    public void setAluno(Aluno aluno) { this.aluno = aluno; }

    public Projeto getProjeto() { return projeto; }
    public void setProjeto(Projeto projeto) { this.projeto = projeto; }

    public Aluno_Projeto() {  }

}