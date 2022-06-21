package com.portfolio.juanpgs.Controller;

import com.portfolio.juanpgs.Entity.Domicilio;
import com.portfolio.juanpgs.Interface.IDomicilioService;
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

public class DomicilioController {
    @Autowired 
    private IDomicilioService iDomicilioService;

    @GetMapping("/domicilio/traer")
    public List<Domicilio> getDomicilio() {
        return iDomicilioService.getDomicilio();
    }

    @PostMapping("/domicilio/crear")
    public String createDomicilio(@RequestBody Domicilio domicilio){        
        iDomicilioService.saveDomicilio(domicilio);
        return "El domicilio fue creado correctamente";
    }

    @DeleteMapping("/domicilio/borrar/{id}")
    public String deleteDomicilio(@PathVariable Long id) {
        iDomicilioService.deleteDomicilio(id);
        return "El domicilio fue eliminado correctamente";
    }

    @GetMapping("domicilio/traer/{id}")
    public Domicilio findDomicilio(@PathVariable Long id) {
        return iDomicilioService.findDomicilio(id);
    }
    
    @PutMapping("/domicilio/editar")
    public String editDomicilio(@RequestBody Domicilio domicilio){
        iDomicilioService.editDomicilio(domicilio);

        return "El domicilio se editó correctamente";
    } 
}