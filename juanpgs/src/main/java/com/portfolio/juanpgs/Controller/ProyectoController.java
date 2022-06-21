package com.portfolio.juanpgs.Controller;

import com.portfolio.juanpgs.Entity.Proyecto;
import com.portfolio.juanpgs.Interface.IProyectoService;
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

public class ProyectoController {
    @Autowired 
    private IProyectoService iProyectoService;

    @GetMapping("/proyecto/traer")
    public List<Proyecto> getProyecto() {
        return iProyectoService.getProyecto();
    }

    @PostMapping("/proyecto/crear")
    public String createProyecto(@RequestBody Proyecto proyecto){        
        iProyectoService.saveProyecto(proyecto);
        return "El proyecto fue creado correctamente";
    }

    @DeleteMapping("/proyecto/borrar/{id}")
    public String deleteProyecto(@PathVariable Long id) {
        iProyectoService.deleteProyecto(id);
        return "El Proyecto fue eliminado correctamente";
    }

    @GetMapping("proyecto/traer/{id}")
    public Proyecto findProyecto(@PathVariable Long id) {
        return iProyectoService.findProyecto(id);
    }
    
    @PutMapping("/proyecto/editar")
    public String editProyecto(@RequestBody Proyecto proyecto){
        iProyectoService.editProyecto(proyecto);

        return "El proyecto se editó correctamente";
    } 
}
