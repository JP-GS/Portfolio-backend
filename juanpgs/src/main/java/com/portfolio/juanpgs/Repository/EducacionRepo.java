package com.portfolio.juanpgs.Repository;

import com.portfolio.juanpgs.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepo extends JpaRepository<Educacion, Integer> {

    public Optional<Educacion> findByNombreEdu(String nombreEdu);

    public boolean existsByNombreEdu(String nombreEdu);
}
