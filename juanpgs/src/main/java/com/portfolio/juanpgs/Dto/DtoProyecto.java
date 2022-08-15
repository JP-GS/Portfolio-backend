package com.portfolio.juanpgs.Dto;

import javax.validation.constraints.NotBlank;

public class DtoProyecto {

    @NotBlank
    private String nombreP;
    @NotBlank
    private String imgP;
    @NotBlank
    private String descripcionP;
    @NotBlank
    private String urlP;

    public DtoProyecto() {
    }

    public DtoProyecto(String nombreP, String imgP, String descripcionP, String urlP) {
        this.nombreP = nombreP;
        this.imgP = imgP;
        this.descripcionP = descripcionP;
        this.urlP = urlP;
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

    public String getUrlP() {
        return urlP;
    }

    public void setUrlP(String urlP) {
        this.urlP = urlP;
    }

}
