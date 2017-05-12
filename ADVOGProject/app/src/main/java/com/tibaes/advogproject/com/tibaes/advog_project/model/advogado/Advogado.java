package com.tibaes.advogproject.com.tibaes.advog_project.model.advogado;

import com.tibaes.advogproject.com.tibaes.advog_project.model.util.Login;
import com.tibaes.advogproject.com.tibaes.advog_project.model.util.Telefone;

import java.io.Serializable;
import java.util.List;

/**
 * Created by juliana tibães on 08/05/2017.
 */

public class Advogado implements Serializable {

    private Long id;
    private Login login;
    private String nomeCompleto;
    private String nomeSocial;
    private String numOab;
    private String ufOab;
    private List<Telefone> telefones;
    private ConfiguracoesAdvogado configuracoes;

    public Advogado() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public String getNumOab() {
        return numOab;
    }

    public void setNumOab(String numOab) {
        this.numOab = numOab;
    }

    public String getUfOab() {
        return ufOab;
    }

    public void setUfOab(String ufOab) {
        this.ufOab = ufOab;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public ConfiguracoesAdvogado getConfiguracoes() {
        return configuracoes;
    }

    public void setConfiguracoes(ConfiguracoesAdvogado configuracoes) {
        this.configuracoes = configuracoes;
    }
}
