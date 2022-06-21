package com.portfolio.juanpgs.Service;

import com.portfolio.juanpgs.Entity.Domicilio;
import com.portfolio.juanpgs.Interface.IDomicilioService;
import com.portfolio.juanpgs.Repository.IDomicilioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ImpDomicilioService implements IDomicilioService{
    @Autowired 
    public IDomicilioRepository iDomicilioRepository;


    @Override
    public List<Domicilio> getDomicilio() {
        List<Domicilio> domicilio = iDomicilioRepository.findAll();
        return domicilio;
    }

    @Override
    public void saveDomicilio(Domicilio domicilio) {
        iDomicilioRepository.save(domicilio);
    }

    @Override
    public void deleteDomicilio (Long id) {
        iDomicilioRepository.deleteById(id);
    }

    @Override
    public Domicilio findDomicilio(Long id) {
        return iDomicilioRepository.findById(id).orElse(null);
    }

    @Override
    public void editDomicilio (Domicilio domicilio) {
        iDomicilioRepository.save(domicilio);
    }
}