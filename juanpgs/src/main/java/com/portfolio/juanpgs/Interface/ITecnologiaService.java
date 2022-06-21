package com.portfolio.juanpgs.Interface;

import com.portfolio.juanpgs.Entity.Tecnologia;
import java.util.List;

public interface ITecnologiaService {
    
    public List<Tecnologia> getTecnologia();    
    public void saveTecnologia(Tecnologia tecnologia);
    public void deleteTecnologia(Long id);
    public Tecnologia findTecnologia(Long id);
    public void editTecnologia(Tecnologia tecnologia);
}
