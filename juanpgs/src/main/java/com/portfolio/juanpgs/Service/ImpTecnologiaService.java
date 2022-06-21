package com.portfolio.juanpgs.Service;

import com.portfolio.juanpgs.Entity.Tecnologia;
import com.portfolio.juanpgs.Interface.ITecnologiaService;
import com.portfolio.juanpgs.Repository.ITecnologiaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ImpTecnologiaService implements ITecnologiaService{
    @Autowired 
    public ITecnologiaRepository iTecnologiaRepository;


    @Override
    public List<Tecnologia> getTecnologia() {
        List<Tecnologia> tecnologia = iTecnologiaRepository.findAll();
        return tecnologia;
    }

    @Override
    public void saveTecnologia (Tecnologia tecnologia) {
        iTecnologiaRepository.save(tecnologia);
    }

    @Override
    public void deleteTecnologia (Long id) {
        iTecnologiaRepository.deleteById(id);
    }

    @Override
    public Tecnologia findTecnologia (Long id) {
        return iTecnologiaRepository.findById(id).orElse(null);
    }

    @Override
    public void editTecnologia (Tecnologia tecnologia) {
        iTecnologiaRepository.save(tecnologia);
    }
}