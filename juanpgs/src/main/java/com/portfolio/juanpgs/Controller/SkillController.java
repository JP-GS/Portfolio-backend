package com.portfolio.juanpgs.Controller;

import com.portfolio.juanpgs.Dto.DtoSkill;
import com.portfolio.juanpgs.Entity.Skill;
import com.portfolio.juanpgs.Security.Controller.Mensaje;
import com.portfolio.juanpgs.Service.SkillService;
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
@CrossOrigin(origins = "https://portfoliojpgs-10307.web.app")
public class SkillController {

    @Autowired
    SkillService skillService;

    @GetMapping("/tecnologia/traer")
    public ResponseEntity<List<Skill>> list() {
        List<Skill> list = skillService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/tecnologia/traer/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") int id) {
        if (!skillService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        Skill skill = skillService.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }

    @PostMapping("/tecnologia/crear")
    public ResponseEntity<Skill> create(@RequestBody DtoSkill dtoSkill) {
        if (StringUtils.isBlank(dtoSkill.getNombreSkill())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (skillService.existsByNombreSkill(dtoSkill.getNombreSkill())) {
            return new ResponseEntity(new Mensaje("Ya existe ese registro"), HttpStatus.BAD_REQUEST);
        }

        Skill skill = new Skill(
                dtoSkill.getNombreSkill(),
                dtoSkill.getImgSkill(),
                dtoSkill.getPorcentaje());
        skillService.save(skill);
        return new ResponseEntity(new Mensaje("Skill creada correctamente"), HttpStatus.OK);
    }

    @PutMapping("/tecnologia/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSkill dtoSkill) {
        if (!skillService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        if (skillService.existsByNombreSkill(dtoSkill.getNombreSkill()) && skillService.getByNombreSkill(dtoSkill.getNombreSkill()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoSkill.getNombreSkill())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Skill skill = skillService.getOne(id).get();
        skill.setNombreSkill(dtoSkill.getNombreSkill());
        skill.setImgSkill(dtoSkill.getImgSkill());
        skill.setPorcentaje(dtoSkill.getPorcentaje());

        skillService.save(skill);
        return new ResponseEntity(new Mensaje("Cambios guardados correctamente"), HttpStatus.OK);
    }

    @DeleteMapping("/tecnologia/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!skillService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        skillService.delete(id);
        return new ResponseEntity(new Mensaje("Skill Eliminada"), HttpStatus.OK);
    }
}
