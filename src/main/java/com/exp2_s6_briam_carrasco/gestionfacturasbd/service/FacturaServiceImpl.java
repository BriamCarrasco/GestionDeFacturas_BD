package com.exp2_s6_briam_carrasco.gestionfacturasbd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.exp2_s6_briam_carrasco.gestionfacturasbd.model.DetalleFactura;
import com.exp2_s6_briam_carrasco.gestionfacturasbd.model.Factura;
import com.exp2_s6_briam_carrasco.gestionfacturasbd.repository.FacturaRepository;


@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;


    @Override
    public List<Factura> getAllFacturas() {
        return facturaRepository.findAll();
    }

    @Override
    public Optional<Factura> getFacturaById(Long id) {
        return facturaRepository.findById(id);
    }


    
    //@Override
    //public Factura createFactura(Factura factura) {
    //    return facturaRepository.save(factura);
    //}

    @Override
public Factura createFactura(Factura factura) {
    // Asigna la factura a cada detalle
    if (factura.getDetalles() != null) {
        for (DetalleFactura detalle : factura.getDetalles()) {
            detalle.setFactura(factura); // Establece la relación bidireccional
        }
    }
    return facturaRepository.save(factura);
}


    @Override
    public void deleteFactura(Long id) {
        facturaRepository.deleteById(id);
    }

    @Override
    public Factura updateFactura(Long id, Factura factura) {
        if (facturaRepository.existsById(id)) {
            factura.setIdFactura(id);
            return facturaRepository.save(factura);
        } else {
            return null; 
        }
    }
    
}
