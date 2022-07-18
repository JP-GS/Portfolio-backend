package com.portfolio.juanpgs.Interface;

import com.portfolio.juanpgs.Entity.Usuario;
import java.util.List;


public interface IUsuarioService {
    public List<Usuario> getUsuario();    
    public void saveUsuario(Usuario usuario);
    public void deleteUsuario(Long id);
    public Usuario findUsuario(Long id);
    public void editUsuario(Usuario usuario);
}
