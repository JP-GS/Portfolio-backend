package com.portfolio.juanpgs.Service;

import com.portfolio.juanpgs.Entity.Experiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.juanpgs.Repository.ExperienciaRepo;

@Service
@Transactional
public class ExperienciaService {

    @Autowired
    ExperienciaRepo experienciaRepo;

    public List<Experiencia> list() {
        return experienciaRepo.findAll();
    }

    public Optional<Experiencia> getOne(int id) {
        return experienciaRepo.findById(id);
    }

    public Optional<Experiencia> getByNombreExp(String nombreExp) {
        return experienciaRepo.findByNombreExp(nombreExp);
    }

    public void save(Experiencia experiencia) {
        experienciaRepo.save(experiencia);
    }

    public void delete(int id) {
        experienciaRepo.deleteById(id);
    }

    public boolean existsById(int id) {
        return experienciaRepo.existsById(id);
    }

    public boolean existsByNombreExp(String nombreExp) {
        return experienciaRepo.existsByNombreExp(nombreExp);
    }
}
