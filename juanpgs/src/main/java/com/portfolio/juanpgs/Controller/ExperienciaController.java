package com.portfolio.juanpgs.Controller;

import com.portfolio.juanpgs.Entity.Experiencia;
import com.portfolio.juanpgs.Interface.IExperienciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class ExperienciaController {
    @Autowired 
    private IExperienciaService iExperienciaService;

    @GetMapping("/experiencia/traer")
    public List<Experiencia> getExperiencia() {
        return iExperienciaService.getExperiencia();
    }

    @PostMapping("/experiencia/crear")
    public String createExperiencia(@RequestBody Experiencia experiencia){        
        iExperienciaService.saveExperiencia(experiencia);
        return "La experiencia fue creada correctamente";
    }

    @DeleteMapping("/experiencia/borrar/{id}")
    public String deleteExperiencia(@PathVariable Long id) {
        iExperienciaService.deleteExperiencia(id);
        return "La experiencia fue eliminada correctamente";
    }

    @GetMapping("experiencia/traer/{id}")
    public Experiencia findExperiencia(@PathVariable Long id) {
        return iExperienciaService.findExperiencia(id);
    }
    
    @PutMapping("/experiencia/editar")
    public String editExperiencia(@RequestBody Experiencia experiencia){
        iExperienciaService.editExperiencia(experiencia);

        return "La experiencia se editó correctamente";
    } 
}
