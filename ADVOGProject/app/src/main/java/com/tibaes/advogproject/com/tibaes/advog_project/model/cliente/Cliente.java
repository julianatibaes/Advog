package com.tibaes.advogproject.com.tibaes.advog_project.model.cliente;

import com.tibaes.advogproject.com.tibaes.advog_project.model.util.Endereco;

import java.io.Serializable;

/**
 * Created by julia on 08/05/2017.
 */

class Cliente implements Serializable{

    private Long id;
    private Endereco endereco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
