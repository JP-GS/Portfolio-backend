package com.portfolio.juanpgs.Security.Repository;

import com.portfolio.juanpgs.Security.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iUsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByNombreUsuario(String nombreUsuario);

    boolean existByNombreUsuario(String nombreUsuario);

    boolean existByEmail(String Email);
}