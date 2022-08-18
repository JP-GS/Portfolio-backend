package com.portfolio.juanpgs.Controller;

import com.portfolio.juanpgs.Dto.DtoPersona;
import com.portfolio.juanpgs.Entity.Persona;
import com.portfolio.juanpgs.Security.Controller.Mensaje;
import com.portfolio.juanpgs.Service.PersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/persona")
@CrossOrigin(origins = "https://portfoliojuan-bd1bb.web.app")

public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/traer")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/traer/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        Persona persona = personaService.getOne(id).get();

        return new ResponseEntity(persona, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DtoPersona dtoPers) {
        if (StringUtils.isBlank(dtoPers.getNombrePers())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (personaService.existsByNombrePers(dtoPers.getNombrePers())) {
            return new ResponseEntity(new Mensaje("El nombre de la persona ya existe"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = new Persona(
                dtoPers.getNombrePers(),
                dtoPers.getApellido(),
                dtoPers.getDescripcion(),
                dtoPers.getImg());
        personaService.save(persona);

        return new ResponseEntity(new Mensaje("Persona agregada"), HttpStatus.OK);
    }

    
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPersona dtoPers) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
        }
        if (personaService.existsByNombrePers(dtoPers.getNombrePers()) && personaService.getByNombrePers(dtoPers.getNombrePers()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa persona ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoPers.getNombrePers())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = personaService.getOne(id).get();
        persona.setNombrePers(dtoPers.getNombrePers());
        persona.setApellido(dtoPers.getApellido());
        persona.setDescripcion(dtoPers.getDescripcion());
        persona.setImg(dtoPers.getImg());

        personaService.save(persona);
        return new ResponseEntity(new Mensaje("Persona Actualizada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }

        personaService.delete(id);
        return new ResponseEntity(new Mensaje("Persona Eliminada"), HttpStatus.OK);
    }
}
