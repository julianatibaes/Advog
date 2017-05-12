package com.tibaes.advogproject.com.tibaes.advog_project.model.util;

/**
 * Created by julia on 08/05/2017.
 */

public class Profissao {

    private Long id;
    private String descricao;

    public Profissao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return  descricao;
    }
}
