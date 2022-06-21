package com.portfolio.juanpgs.Interface;

import com.portfolio.juanpgs.Entity.Proyecto;
import java.util.List;

public interface IProyectoService {
    
    public List<Proyecto> getProyecto();    
    public void saveProyecto(Proyecto proyecto);
    public void deleteProyecto(Long id);
    public Proyecto findProyecto(Long id);
    public void editProyecto(Proyecto proyecto);
}
