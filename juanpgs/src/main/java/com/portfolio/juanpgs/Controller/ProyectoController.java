package com.portfolio.juanpgs.Controller;

import com.portfolio.juanpgs.Dto.DtoProyecto;
import com.portfolio.juanpgs.Entity.Proyecto;
import com.portfolio.juanpgs.Security.Controller.Mensaje;
import com.portfolio.juanpgs.Service.ProyectoService;
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
@RequestMapping("proyecto")
@CrossOrigin(origins = "https://portfoliojuan-bd1bb.web.app/")
public class ProyectoController {

    @Autowired
    ProyectoService proyectoService;

    @GetMapping("/traer")
    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = proyectoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/traer/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id) {
        if (!proyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        Proyecto proyecto = proyectoService.getOne(id).get();

        return new ResponseEntity(proyecto, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Proyecto> create(@RequestBody DtoProyecto dtoProyecto) {
        if (StringUtils.isBlank(dtoProyecto.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (proyectoService.existsByNombreP(dtoProyecto.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombre del proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        Proyecto proyecto = new Proyecto(
                dtoProyecto.getNombreP(),
                dtoProyecto.getImgP(),
                dtoProyecto.getDescripcionP(),
                dtoProyecto.getUrlP());
        proyectoService.save(proyecto);

        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyecto dtoProyecto) {
        if (!proyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
        }
        if (proyectoService.existsByNombreP(dtoProyecto.getNombreP()) && proyectoService.getOneByNombreP(dtoProyecto.getNombreP()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese Proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoProyecto.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Proyecto proyecto = proyectoService.getOne(id).get();

        proyecto.setNombreP(dtoProyecto.getNombreP());
        proyecto.setImgP(dtoProyecto.getImgP());
        proyecto.setDescripcionP(dtoProyecto.getDescripcionP());
        proyecto.setUrlP(dtoProyecto.getUrlP());

        proyectoService.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto Actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!proyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }

        proyectoService.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto Eliminado"), HttpStatus.OK);
    }
}
