package com.portfolio.juanpgs.Controller;

import com.portfolio.juanpgs.Dto.DtoEducacion;
import com.portfolio.juanpgs.Entity.Educacion;
import com.portfolio.juanpgs.Security.Controller.Mensaje;
import com.portfolio.juanpgs.Service.EducacionService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://portfoliojpgs-71a02.web.app")
public class EducacionController {

    @Autowired
    EducacionService educacionService;

    @GetMapping("/educacion/traer")
    public ResponseEntity<List<Educacion>> educationlist() {
        List<Educacion> list = educacionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/educacion/traer/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id) {
        if (!educacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
        }
        Educacion educacion = educacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @PostMapping("/educacion/crear")
    public ResponseEntity<Educacion> create(@RequestBody DtoEducacion dtoEducacion) {
        if (StringUtils.isBlank(dtoEducacion.getNombreEdu())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = new Educacion(
                dtoEducacion.getNombreEdu(),
                dtoEducacion.getTitulo(),
                dtoEducacion.getCarrera(),
                dtoEducacion.getImgEdu(),
                dtoEducacion.getInicio(),
                dtoEducacion.getFin());
        educacionService.save(educacion);

        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
    }

    @PutMapping("/educacion/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoEducacion) {
        if (!educacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
        }

        if (StringUtils.isBlank(dtoEducacion.getNombreEdu())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = educacionService.getOne(id).get();
        educacion.setNombreEdu(dtoEducacion.getNombreEdu());
        educacion.setTitulo(dtoEducacion.getTitulo());
        educacion.setCarrera(dtoEducacion.getCarrera());
        educacion.setImgEdu(dtoEducacion.getImgEdu());
        educacion.setInicio(dtoEducacion.getInicio());
        educacion.setFin(dtoEducacion.getFin());

        educacionService.save(educacion);
        return new ResponseEntity(new Mensaje("Se guardaron los cambios"), HttpStatus.OK);
    }

    @DeleteMapping("/educacion/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {

        if (!educacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
        }

        educacionService.delete(id);
        return new ResponseEntity(new Mensaje("Se eliminó la educacion"), HttpStatus.OK);
    }
}
