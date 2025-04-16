package com.exp2_s6_briam_carrasco.gestionfacturasbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp2_s6_briam_carrasco.gestionfacturasbd.model.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long> {

    
}
