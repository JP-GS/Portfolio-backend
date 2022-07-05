package com.portfolio.juanpgs.Security.Service;

import com.portfolio.juanpgs.Security.Entity.Usuario;
import com.portfolio.juanpgs.Security.Repository.iUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    iUsuarioRepository iusuarioRepo;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
        return iusuarioRepo.findByNombreUsuario(nombreUsuario);
    }

    public boolean existByNombreUsuario(String nombreUsuario) {
        return iusuarioRepo.existByNombreUsuario(nombreUsuario);
    }

    public boolean existByEmail(String email) {
        return iusuarioRepo.existByEmail(email);
    }

    public void save(Usuario usuario) {
        iusuarioRepo.save(usuario);
    }
}
