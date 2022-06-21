package com.portfolio.juanpgs.Service;

import com.portfolio.juanpgs.Entity.Proyecto;
import com.portfolio.juanpgs.Interface.IProyectoService;
import com.portfolio.juanpgs.Repository.IProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ImpProyectoService implements IProyectoService{
    @Autowired 
    public IProyectoRepository iProyectoRepository;


    @Override
    public List<Proyecto> getProyecto() {
        List<Proyecto> proyecto = iProyectoRepository.findAll();
        return proyecto;
    }

    @Override
    public void saveProyecto (Proyecto proyecto) {
        iProyectoRepository.save(proyecto);
    }

    @Override
    public void deleteProyecto (Long id) {
        iProyectoRepository.deleteById(id);
    }

    @Override
    public Proyecto findProyecto (Long id) {
        return iProyectoRepository.findById(id).orElse(null);
    }

    @Override
    public void editProyecto(Proyecto proyecto) {
        iProyectoRepository.save(proyecto);
    }
}