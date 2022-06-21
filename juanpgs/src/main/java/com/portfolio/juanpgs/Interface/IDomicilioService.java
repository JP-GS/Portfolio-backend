package com.portfolio.juanpgs.Interface;

import com.portfolio.juanpgs.Entity.Domicilio;
import java.util.List;

public interface IDomicilioService {
    
    public List<Domicilio> getDomicilio();    
    public void saveDomicilio(Domicilio domicilio);
    public void deleteDomicilio(Long id);
    public Domicilio findDomicilio(Long id);
    public void editDomicilio(Domicilio domicilio);
}
