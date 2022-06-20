package com.portfolio.juanpgs.Controller;

import com.portfolio.juanpgs.Entity.Educacion;
import com.portfolio.juanpgs.Interface.IEducacionService;
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

public class EducacionController {
    @Autowired 
    private IEducacionService iEducacionService;

    @GetMapping("/educacion/traer")
    public List<Educacion> getEducacion() {
        return iEducacionService.getEducacion();
    }

    @PostMapping("/educacion/crear")
    public String createEducacion(@RequestBody Educacion educacion){        
        iEducacionService.saveEducacion(educacion);
        return "La educacion fue creada correctamente";
    }

    @DeleteMapping("/educacion/borrar/{id}")
    public String deleteEducacion(@PathVariable Long id) {
        iEducacionService.deleteEducacion(id);
        return "La educacion fue eliminada correctamente";
    }

    @GetMapping("educacion/traer/estudio/{id}")
    public Educacion findEducacion(@PathVariable Long id) {
        return iEducacionService.findEducacion(id);
    }
    
    @PutMapping("/educacion/editar")
    public String editEducacion(@RequestBody Educacion educacion){
        iEducacionService.editEducacion(educacion);

        return "La educacion se editó correctamente";
    } 
}
