package com.portfolio.juanpgs.Dto;

import javax.validation.constraints.NotBlank;

public class DtoProyecto {

    @NotBlank
    private String nombreP;
    @NotBlank
    private String imgP;
    @NotBlank
    private String descripcionP;

    public DtoProyecto() {
    }

    public DtoProyecto(String nombreP, String imgP, String descripcionP) {
        this.nombreP = nombreP;
        this.imgP = imgP;
        this.descripcionP = descripcionP;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getImgP() {
        return imgP;
    }

    public void setImgP(String imgP) {
        this.imgP = imgP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }



}
