package com.exp2_s6_briam_carrasco.gestionfacturasbd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exp2_s6_briam_carrasco.gestionfacturasbd.model.Emisor;
import com.exp2_s6_briam_carrasco.gestionfacturasbd.repository.EmisorRepository;


@Service
public class EmisorServiceImpl implements EmisorService{
    
    @Autowired
    private EmisorRepository emisorRepository;

    @Override
    public List<Emisor> getAllEmisores() {
        return emisorRepository.findAll();
    }

    @Override
    public Optional<Emisor> getEmisorById(Long id) {
        return emisorRepository.findById(id);
    }

    @Override
    public Emisor createEmisor(Emisor emisor){
        if (emisorRepository.existsByRutEmisor(emisor.getRutEmisor())) {
            throw new IllegalArgumentException("El RUT ya existe");
        }
        return emisorRepository.save(emisor);
    }


    @Override
    public void deleteEmisor(Long id) {
        emisorRepository.deleteById(id);
    }

    @Override
    public Emisor updateEmisor(Long id, Emisor emisor) {
        if (emisorRepository.existsById(id)) {
            emisor.setIdEmisor(id);
            return emisorRepository.save(emisor);
        } else {
            return null; 
        }
    }

        
}
