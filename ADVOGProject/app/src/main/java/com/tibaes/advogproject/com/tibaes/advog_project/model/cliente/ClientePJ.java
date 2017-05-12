package com.tibaes.advogproject.com.tibaes.advog_project.model.cliente;

import java.util.List;

/**
 * Created by juliana tibães on 08/05/2017.
 */

public class ClientePJ extends Cliente {

    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private List<ClienteRepresentante> representantesFisico;

    public ClientePJ() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public List<ClienteRepresentante> getRepresentantesFisico() {
        return representantesFisico;
    }

    public void setRepresentantesFisico(List<ClienteRepresentante> representantesFisico) {
        this.representantesFisico = representantesFisico;
    }

    @Override
    public String toString() {
        return  nomeFantasia + '\n' + cnpj;
    }
}
