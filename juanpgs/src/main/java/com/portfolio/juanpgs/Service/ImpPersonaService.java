package com.portfolio.juanpgs.Service;

import com.portfolio.juanpgs.Entity.Persona;
import com.portfolio.juanpgs.Interface.IPersonaService;
import com.portfolio.juanpgs.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ImpPersonaService implements IPersonaService{
    @Autowired 
    public IPersonaRepository iPersonaRepository;


    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = iPersonaRepository.findAll();
        return persona;
    }

    @Override
    public void savePersona (Persona persona) {
        iPersonaRepository.save(persona);
    }

    @Override
    public void deletePersona (Long id) {
        iPersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona (Long id) {
        return iPersonaRepository.findById(id).orElse(null);
    }

    @Override
    public void editPersona (Persona pers) {
        iPersonaRepository.save(pers);
    }
}