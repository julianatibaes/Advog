package com.tibaes.advogproject.com.tibaes.advog_project.model.util;

/**
 * Created by julia on 08/05/2017.
 */

public class Telefone {

    private String numTelefone;
    private String tipoTelefone;

    public Telefone() {
    }

    public Telefone(String numTelefone, String tipoTelefone) {
        this.numTelefone = numTelefone;
        this.tipoTelefone = tipoTelefone;
    }

    public String getNumTelefone() {
        return numTelefone;
    }

    public void setNumTelefone(String numTelefone) {
        this.numTelefone = numTelefone;
    }

    public String getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(String tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    @Override
    public String toString() {
        return tipoTelefone + " " + numTelefone;
    }
}
