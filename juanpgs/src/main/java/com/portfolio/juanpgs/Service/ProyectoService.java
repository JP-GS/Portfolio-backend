package com.portfolio.juanpgs.Service;

import com.portfolio.juanpgs.Entity.Proyecto;
import com.portfolio.juanpgs.Repository.ProyectoRepo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectoService {

    @Autowired
    ProyectoRepo rProyecto;

    public List<Proyecto> list() {
        return rProyecto.findAll();
    }

    public Optional<Proyecto> getOne(int id) {
        return rProyecto.findById(id);
    }

    public Optional<Proyecto> getOneByNombreP(String nombreP) {
        return rProyecto.findByNombreP(nombreP);
    }

    public void save(Proyecto proyecto) {
        rProyecto.save(proyecto);
    }

    public void delete(int id) {
        rProyecto.deleteById(id);
    }

    public boolean existsById(int id) {
        return rProyecto.existsById(id);
    }
    public boolean existsByNombreP(String nombreP) {
        return rProyecto.existsByNombreP(nombreP);
    }
}
