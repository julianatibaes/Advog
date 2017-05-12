package com.tibaes.advogproject.com.tibaes.advog_project.model.cliente;

import com.tibaes.advogproject.com.tibaes.advog_project.model.util.Login;
import com.tibaes.advogproject.com.tibaes.advog_project.model.util.Profissao;
import com.tibaes.advogproject.com.tibaes.advog_project.model.util.Telefone;

import java.util.List;

/**
 * Created by julia on 08/05/2017.
 */

public class ClienteRepresentante extends ClientePF {

    private Profissao profissao;
    private Login login;

    public ClienteRepresentante() {
    }

    public ClienteRepresentante(String nomeSocial){
        setNomeSocial(nomeSocial);
    }
    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return getNomeSocial();
    }
}
