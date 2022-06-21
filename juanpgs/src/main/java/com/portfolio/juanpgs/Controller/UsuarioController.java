package com.portfolio.juanpgs.Controller;

import com.portfolio.juanpgs.Entity.Usuario;
import com.portfolio.juanpgs.Interface.IUsuarioService;
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

public class UsuarioController {
    @Autowired 
    private IUsuarioService iUsuarioService;

    @GetMapping("/usuario/traer")
    public List<Usuario> getUsuario() {
        return iUsuarioService.getUsuario();
    }

    @PostMapping("/usuario/crear")
    public String createUsuario(@RequestBody Usuario usuario){        
        iUsuarioService.saveUsuario(usuario);
        return "La persona fue creada correctamente";
    }

    @DeleteMapping("/usuario/borrar/{id}")
    public String deleteUsuario(@PathVariable Long id) {
        iUsuarioService.deleteUsuario(id);
        return "El usuario fue eliminado correctamente";
    }

    @GetMapping("usuario/traer/{id}")
    public Usuario findUsuario(@PathVariable Long id) {
        return iUsuarioService.findUsuario(id);
    }
    
    @PutMapping("/usuario/editar")
    public String editUsuario(@RequestBody Usuario usuario){
        iUsuarioService.editUsuario(usuario);

        return "El usuario se editó correctamente";
    } 
}
