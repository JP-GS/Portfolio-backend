package com.portfolio.juanpgs.Dto;

import javax.validation.constraints.NotBlank;

public class DtoExperiencia {

    @NotBlank
    private String nombreExp;
    @NotBlank
    private String puesto;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String imgExp;
    @NotBlank
    private String inicio;
    @NotBlank
    private String fin;

//Constructor
    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreExp, String puesto, String descripcion, String imgExp, String inicio, String fin) {
        this.nombreExp = nombreExp;
        this.puesto = puesto;
        this.descripcion = descripcion;
        this.imgExp = imgExp;
        this.inicio = inicio;
        this.fin = fin;
    }

   

//Getters & Setters

    public String getNombreExp() {
        return nombreExp;
    }

    public void setNombreExp(String nombreExp) {
        this.nombreExp = nombreExp;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImgExp() {
        return imgExp;
    }

    public void setImgExp(String imgExp) {
        this.imgExp = imgExp;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }


}
