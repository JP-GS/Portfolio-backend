package com.portfolio.juanpgs.Service;

import com.portfolio.juanpgs.Entity.Experiencia;
import com.portfolio.juanpgs.Interface.IExperienciaService;
import com.portfolio.juanpgs.Repository.IExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ImpExperienciaService implements IExperienciaService{
    @Autowired 
    public IExperienciaRepository iExperienciaRepository;


    @Override
    public List<Experiencia> getExperiencia() {
        List<Experiencia> experiencia = iExperienciaRepository.findAll();
        return experiencia;
    }

    @Override
    public void saveExperiencia (Experiencia experiencia) {
        iExperienciaRepository.save(experiencia);
    }

    @Override
    public void deleteExperiencia (Long id) {
        iExperienciaRepository.deleteById(id);
    }

    @Override
    public Experiencia findExperiencia (Long id) {
        return iExperienciaRepository.findById(id).orElse(null);
    }

    @Override
    public void editExperiencia (Experiencia experiencia) {
        iExperienciaRepository.save(experiencia);
    }
}
