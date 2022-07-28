package com.portfolio.juanpgs.Dto;

import javax.validation.constraints.NotBlank;

public class DtoEducacion {

    @NotBlank
    private String nombreEdu;
    @NotBlank
    private String titulo;
    @NotBlank
    private String carrera;
    @NotBlank
    private String imgEdu;
    @NotBlank
    private String inicio;
    @NotBlank
    private String fin;

    public DtoEducacion() {
    }

    public DtoEducacion(String nombreEdu, String titulo, String carrera, String imgEdu, String inicio, String fin) {
        this.nombreEdu = nombreEdu;
        this.titulo = titulo;
        this.carrera = carrera;
        this.imgEdu = imgEdu;
        this.inicio = inicio;
        this.fin = fin;
    }

    public String getNombreEdu() {
        return nombreEdu;
    }

    public void setNombreEdu(String nombreEdu) {
        this.nombreEdu = nombreEdu;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getImgEdu() {
        return imgEdu;
    }

    public void setImgEdu(String imgEdu) {
        this.imgEdu = imgEdu;
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
