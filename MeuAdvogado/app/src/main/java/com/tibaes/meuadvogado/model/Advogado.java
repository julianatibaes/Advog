package com.tibaes.meuadvogado.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Juliana Tibães on 19/05/2017.
 * MeuAdvogado
 * com.tibaes.meuadvogado.model
 */

public class Advogado extends Pessoa implements Serializable {

    private String oab;
    private Date inicioAtuacao;
    private List<AreaAtuacao> areaAtuacoes;
    private Float classificacao; // nota dos clientes

    public Advogado() {
    }

    public String getOab() {
        return oab;
    }

    public void setOab(String oab) {
        this.oab = oab;
    }

    public Date getInicioAtuacao() {
        return inicioAtuacao;
    }

    public void setInicioAtuacao(Date inicioAtuacao) {
        this.inicioAtuacao = inicioAtuacao;
    }

    public List<AreaAtuacao> getAreaAtuacoes() {
        return areaAtuacoes;
    }

    public void setAreaAtuacoes(List<AreaAtuacao> areaAtuacoes) {
        this.areaAtuacoes = areaAtuacoes;
    }

    public Float getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Float classificacao) {
        this.classificacao = classificacao;
    }
}
