package com.exp2_s6_briam_carrasco.gestionfacturasbd.service;

import java.util.List;
import java.util.Optional;

import com.exp2_s6_briam_carrasco.gestionfacturasbd.model.Emisor;

public interface EmisorService {

    List<Emisor> getAllEmisores();
    Optional<Emisor> getEmisorById(Long id);
    Emisor createEmisor(Emisor emisor);
    Emisor updateEmisor(Long id, Emisor emisor);
    void deleteEmisor(Long id);
    
    
}
