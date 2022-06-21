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
public class Tecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String nombre;

    @Size(min = 1, max = 4, message = "No cumple con la longitud")
    private String porcentaje; 

    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String img;
}
