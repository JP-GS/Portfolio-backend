package com.portfolio.juanpgs.Controller;

import com.portfolio.juanpgs.Dto.DtoExperiencia;
import com.portfolio.juanpgs.Entity.Experiencia;
import com.portfolio.juanpgs.Security.Controller.Mensaje;
import com.portfolio.juanpgs.Service.ExperienciaService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experiencia")
@CrossOrigin(origins = "http://localhost:4200/")
public class ExperienciaController {

    @Autowired
    ExperienciaService experienciaService;

    @GetMapping("/traer")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = experienciaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/traer/{id}")
    public ResponseEntity<Experiencia> detail(@PathVariable("id") int id) {
        Experiencia experiencia = experienciaService.getOne(id).get();

        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoExp) {
        if (StringUtils.isBlank(dtoExp.getNombreExp())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (experienciaService.existsByNombreExp(dtoExp.getNombreExp())) {
            return new ResponseEntity(new Mensaje("El nombre de la experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        Experiencia experiencia = new Experiencia(
                dtoExp.getNombreExp(),
                dtoExp.getPuesto(),
                dtoExp.getDescripcion(),
                dtoExp.getImgExp(),
                dtoExp.getInicio(),
                dtoExp.getFin());
        experienciaService.save(experiencia);

        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoExp) {
        if (!experienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if (experienciaService.existsByNombreExp(dtoExp.getNombreExp()) && experienciaService.getByNombreExp(dtoExp.getNombreExp()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoExp.getNombreExp())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Experiencia experiencia = experienciaService.getOne(id).get();
        experiencia.setNombreExp(dtoExp.getNombreExp());
        experiencia.setPuesto(dtoExp.getPuesto());
        experiencia.setDescripcion(dtoExp.getDescripcion());
        experiencia.setImgExp(dtoExp.getImgExp());
        experiencia.setInicio(dtoExp.getInicio());
        experiencia.setFin(dtoExp.getFin());

        experienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia Actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!experienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }

        experienciaService.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia Eliminada"), HttpStatus.OK);
    }
}
