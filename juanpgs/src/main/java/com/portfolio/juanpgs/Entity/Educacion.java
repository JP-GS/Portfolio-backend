package com.portfolio.juanpgs.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreEdu;
    private String titulo;
    private String carrera;
    private String imgEdu;
    private String inicio;
    private String fin;

    public Educacion() {
    }

    public Educacion(String nombreEdu, String titulo, String carrera, String imgEdu, String inicio, String fin) {
        this.nombreEdu = nombreEdu;
        this.titulo = titulo;
        this.carrera = carrera;
        this.imgEdu = imgEdu;
        this.inicio = inicio;
        this.fin = fin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
