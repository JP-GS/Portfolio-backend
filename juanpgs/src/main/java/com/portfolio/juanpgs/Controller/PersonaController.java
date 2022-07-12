package com.portfolio.juanpgs.Controller;

import com.portfolio.juanpgs.Entity.Persona;
import com.portfolio.juanpgs.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class PersonaController {
    
    @Autowired
    private IPersonaService iPersonaService;
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersona() {
        return iPersonaService.getPersona();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona) {
        iPersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        iPersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    
    @GetMapping("personas/traer/{id}")
    public Persona findPersona(@PathVariable Long id) {
        return iPersonaService.findPersona(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar")
    public String editPersona(@RequestBody Persona persona) {
        iPersonaService.editPersona(persona);
        return "La persona se editó correctamente";
    }
}
