package com.exp2_s6_briam_carrasco.gestionfacturasbd.service;

import java.util.List;
import java.util.Optional;

import com.exp2_s6_briam_carrasco.gestionfacturasbd.model.Factura;

public interface FacturaService {
    
    List<Factura> getAllFacturas();
    Optional<Factura> getFacturaById(Long id);
    Factura createFactura(Factura factura);
    Factura updateFactura(Long id, Factura factura);
    void deleteFactura(Long id);
}
