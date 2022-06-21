package com.portfolio.juanpgs.Controller;

import com.portfolio.juanpgs.Entity.Tecnologia;
import com.portfolio.juanpgs.Interface.ITecnologiaService;
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

public class TecnologiaController {
    @Autowired 
    private ITecnologiaService iTecnologiaService;

    @GetMapping("/tecnologia/traer")
    public List<Tecnologia> getTecnologia() {
        return iTecnologiaService.getTecnologia();
    }

    @PostMapping("/tecnologia/crear")
    public String createTecnologia(@RequestBody Tecnologia tecnologia){        
        iTecnologiaService.saveTecnologia(tecnologia);
        return "La tecnologia fue creada correctamente";
    }

    @DeleteMapping("/tecnologia/borrar/{id}")
    public String deleteTecnologia(@PathVariable Long id) {
        iTecnologiaService.deleteTecnologia(id);
        return "La tecnologia fue eliminada correctamente";
    }

    @GetMapping("tecnologia/traer/{id}")
    public Tecnologia findTecnologia(@PathVariable Long id) {
        return iTecnologiaService.findTecnologia(id);
    }
    
    @PutMapping("/tecnologia/editar")
    public String editTecnologia(@RequestBody Tecnologia tecnologia){
        iTecnologiaService.editTecnologia(tecnologia);

        return "La Tecnologia se editó correctamente";
    } 
}