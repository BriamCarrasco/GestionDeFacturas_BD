package com.exp2_s6_briam_carrasco.gestionfacturasbd.service;

import java.util.List;
import java.util.Optional;

import com.exp2_s6_briam_carrasco.gestionfacturasbd.model.DetalleFactura;

public interface DetalleFacturaService {

    List<DetalleFactura> getAllDetallesFactura();
    Optional<DetalleFactura> getDetalleFacturaById(Long id);
    DetalleFactura createDetalleFactura(DetalleFactura detalleFactura);
    DetalleFactura updateDetalleFactura(Long id, DetalleFactura detalleFactura);
    void deleteDetalleFactura(Long id);
    
}
