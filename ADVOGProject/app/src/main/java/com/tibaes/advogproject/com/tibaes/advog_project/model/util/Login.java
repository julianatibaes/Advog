package com.tibaes.advogproject.com.tibaes.advog_project.model.util;

/**
 * Created by julia on 08/05/2017.
 */

public class Login {

    private String email;
    private String senha;
    private String caminhoFoto;

    public Login() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCaminhoFoto() {
        return caminhoFoto;
    }

    public void setCaminhoFoto(String caminhoFoto) {
        this.caminhoFoto = caminhoFoto;
    }
}
