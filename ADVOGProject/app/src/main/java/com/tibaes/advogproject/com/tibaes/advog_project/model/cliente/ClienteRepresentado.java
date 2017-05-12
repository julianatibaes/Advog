package com.tibaes.advogproject.com.tibaes.advog_project.model.cliente;

import java.util.Date;

/**
 * Created by julia on 08/05/2017.
 */

public class ClienteRepresentado extends ClientePF {

    public ClienteRepresentante representanteLegal;
    public Date dt_nascimento;

    public ClienteRepresentado() {
    }

    public ClienteRepresentante getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(ClienteRepresentante representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public Date getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    @Override
    public String toString() {
        return getNomeSocial();
    }
}
