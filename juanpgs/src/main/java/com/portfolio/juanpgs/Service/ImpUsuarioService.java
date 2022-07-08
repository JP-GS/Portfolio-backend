package com.portfolio.juanpgs.Service;

import com.portfolio.juanpgs.Entity.Usuario;
import com.portfolio.juanpgs.Interface.IUsuarioService;
import com.portfolio.juanpgs.Repository.IUsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpUsuarioService implements IUsuarioService {
    @Autowired
    public IUsuarioRepository iUsuarioRepository;

    @Override
    public List<Usuario> getUsuario() {
            List<Usuario> usuario = iUsuarioRepository.findAll();
            return usuario;
        }

    @Override
    public void saveUsuario (Usuario usuario) {
        iUsuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(Long id) {
        iUsuarioRepository.deleteById(id);
    }

    @Override
    public Usuario findUsuario(Long id) {
        return iUsuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void editUsuario (Usuario usuario) {
        iUsuarioRepository.save(usuario);
    }
}
