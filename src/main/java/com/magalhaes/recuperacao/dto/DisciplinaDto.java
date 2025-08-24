package com.magalhaes.recuperacao.dto;
import com.magalhaes.recuperacao.modelo.*;

public class DisciplinaDto {
    
    private Long id;
    private String nome;

    @Deprecated
    public DisciplinaDto() {
    }

    public DisciplinaDto(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Disciplina novaDisciplina(){
        return new Disciplina(nome);
    }
    

}

