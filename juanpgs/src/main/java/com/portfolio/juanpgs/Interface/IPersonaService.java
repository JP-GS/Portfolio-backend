package com.portfolio.juanpgs.Interface;

import com.portfolio.juanpgs.Entity.Persona;
import java.util.List;

public interface IPersonaService {
    
    public List<Persona> getPersona();    
    public void savePersona(Persona persona);
    public void deletePersona(Long id);
    public Persona findPersona(Long id);
    public void editPersona(Persona pers);
}
