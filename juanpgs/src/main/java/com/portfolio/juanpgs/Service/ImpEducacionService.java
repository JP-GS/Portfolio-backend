package com.portfolio.juanpgs.Service;

import com.portfolio.juanpgs.Entity.Educacion;
import com.portfolio.juanpgs.Interface.IEducacionService;
import com.portfolio.juanpgs.Repository.IEducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ImpEducacionService implements IEducacionService{
    @Autowired 
    public IEducacionRepository iEducacionRepository;


    @Override
    public List<Educacion> getEducacion() {
        List<Educacion> educacion = iEducacionRepository.findAll();
        return educacion;
    }

    @Override
    public void saveEducacion (Educacion educacion) {
        iEducacionRepository.save(educacion);
    }

    @Override
    public void deleteEducacion (Long id) {
        iEducacionRepository.deleteById(id);
    }

    @Override
    public Educacion findEducacion (Long id) {
        return iEducacionRepository.findById(id).orElse(null);
    }

    @Override
    public void editEducacion (Educacion educacion) {
        iEducacionRepository.save(educacion);
    }
}
