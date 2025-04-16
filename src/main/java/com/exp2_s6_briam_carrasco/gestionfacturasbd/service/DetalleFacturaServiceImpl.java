package com.exp2_s6_briam_carrasco.gestionfacturasbd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exp2_s6_briam_carrasco.gestionfacturasbd.model.DetalleFactura;
import com.exp2_s6_briam_carrasco.gestionfacturasbd.repository.DetalleFacturaRepository;

@Service
public class DetalleFacturaServiceImpl implements DetalleFacturaService {
    
    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    @Override
    public List<DetalleFactura> getAllDetallesFactura() {
        return detalleFacturaRepository.findAll();
    }

    @Override
    public Optional<DetalleFactura> getDetalleFacturaById(Long id) {
        return detalleFacturaRepository.findById(id);
    }

    @Override
    public DetalleFactura createDetalleFactura(DetalleFactura detalleFactura) {
        return detalleFacturaRepository.save(detalleFactura);
    }

    @Override
    public void deleteDetalleFactura(Long id) {
        detalleFacturaRepository.deleteById(id);
    }

    @Override
    public DetalleFactura updateDetalleFactura(Long id, DetalleFactura detalleFactura) {
        if (detalleFacturaRepository.existsById(id)) {
            detalleFactura.setIdDetalleFactura(id);
            return detalleFacturaRepository.save(detalleFactura);
        } else {
            return null; 
        }
    }
    
}
