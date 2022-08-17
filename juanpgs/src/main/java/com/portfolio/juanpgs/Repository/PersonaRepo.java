package com.portfolio.juanpgs.Repository;

import com.portfolio.juanpgs.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepo extends JpaRepository<Persona, Integer> {
        public Optional<Persona> findByNombrePers(String nombrePers);

    public boolean existsByNombrePers(String nombrePers);
}
