package com.portfolio.juanpgs.Dto;

import javax.validation.constraints.NotBlank;

public class DtoSkill {

    @NotBlank
    private String nombreSkill;
    @NotBlank
    private String imgSkill;
    @NotBlank
    private int porcentaje;

    public DtoSkill() {
    }

    public DtoSkill(String nombreSkill, String imgSkill, int porcentaje) {
        this.nombreSkill = nombreSkill;
        this.imgSkill = imgSkill;
        this.porcentaje = porcentaje;
    }

    public String getNombreSkill() {
        return nombreSkill;
    }

    public void setNombreSkill(String nombreSkill) {
        this.nombreSkill = nombreSkill;
    }

    public String getImgSkill() {
        return imgSkill;
    }

    public void setImgSkill(String imgSkill) {
        this.imgSkill = imgSkill;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    
}
