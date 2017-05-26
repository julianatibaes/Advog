package com.tibaes.meuadvogado.model;

/**
 * Created by Juliana Tibães on 19/05/2017.
 * MeuAdvogado
 * com.tibaes.meuadvogado.model
 */

public class AreaAtuacao {

    private Long id;
    private String descricao;

    public AreaAtuacao() {
    }

    public AreaAtuacao(String descricao){
        setDescricao(descricao);
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
        return  "id= " + id +
                "\n descricao= '" + descricao;
    }
}
