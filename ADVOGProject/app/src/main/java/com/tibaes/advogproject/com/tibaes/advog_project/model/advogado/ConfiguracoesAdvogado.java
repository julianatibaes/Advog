package com.tibaes.advogproject.com.tibaes.advog_project.model.advogado;

/**
 * Created by julia on 08/05/2017.
 */

public class ConfiguracoesAdvogado {

    private Integer horarioInicio; // corresponte ao horário que o adv começa a trabalhar
    private Integer horarioFinal; // corresponte ao horário que o adv para a trabalhar
    private Integer diasTrabalho; // ordem dos dígitos D, S, T, Q, Q, S, S, sendo 1 para ativo e 2 para inativo
    private Boolean ferias;
    private Boolean alertas;

    public ConfiguracoesAdvogado() {
    }

    public Integer getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(Integer horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public Integer getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(Integer horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    public Integer getDiasTrabalho() {
        return diasTrabalho;
    }

    public void setDiasTrabalho(Integer diasTrabalho) {
        this.diasTrabalho = diasTrabalho;
    }

    public Boolean getFerias() {
        return ferias;
    }

    public void setFerias(Boolean ferias) {
        this.ferias = ferias;
    }

    public Boolean getAlertas() {
        return alertas;
    }

    public void setAlertas(Boolean alertas) {
        this.alertas = alertas;
    }
}
