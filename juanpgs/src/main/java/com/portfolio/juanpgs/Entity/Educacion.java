package com.portfolio.juanpgs.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String nombre;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String titulo;

    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String img;

    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String carrera;

    //@NotNull
    //private Int puntaje;

    @Size(min = 1, max = 4, message = "No cumple con la longitud")
    private String inicio;

    @Size(min = 1, max = 4, message = "No cumple con la longitud")
    private String fin;
}
