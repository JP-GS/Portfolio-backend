package com.portfolio.juanpgs.Service;

import com.portfolio.juanpgs.Entity.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.juanpgs.Repository.PersonaRepo;
import java.util.Optional;
import javax.transaction.Transactional;


@Service
@Transactional
public class PersonaService{
    @Autowired 
    public PersonaRepo personaRepo;

    public List<Persona> list() {
        return personaRepo.findAll();
    }

    public Optional<Persona> getOne(int id) {
        return personaRepo.findById(id);
    }

    public Optional<Persona> getByNombrePers(String nombrePers) {
        return personaRepo.findByNombrePers(nombrePers);
    }

    public void save(Persona persona) {
        personaRepo.save(persona);
    }

    public void delete(int id) {
        personaRepo.deleteById(id);
    }

    public boolean existsById(int id) {
        return personaRepo.existsById(id);
    }

    public boolean existsByNombrePers(String nombrePers) {
        return personaRepo.existsByNombrePers(nombrePers);
    }
}