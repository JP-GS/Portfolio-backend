package com.portfolio.juanpgs.Interface;

import com.portfolio.juanpgs.Entity.Educacion;
import java.util.List;

public interface IEducacionService {
    
    public List<Educacion> getEducacion();    
    public void saveEducacion(Educacion educacion);
    public void deleteEducacion(Long id);
    public Educacion findEducacion(Long id);
    public void editEducacion(Educacion educacion);
}
