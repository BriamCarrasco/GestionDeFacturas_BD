package com.exp2_s6_briam_carrasco.gestionfacturasbd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exp2_s6_briam_carrasco.gestionfacturasbd.model.DetalleFactura;
import com.exp2_s6_briam_carrasco.gestionfacturasbd.service.DetalleFacturaService;

@RestController
@RequestMapping("/detallefactura")
@CrossOrigin(origins = "*")
public class DetalleFacturaController {
    
    @Autowired
    private DetalleFacturaService  detalleFacturaService;

    @GetMapping
    public List<DetalleFactura> getAllDetallesFactura() {
        return detalleFacturaService.getAllDetallesFactura();
    }

    @GetMapping("/{id}")
    public Optional<DetalleFactura> getDetalleFacturaById(@PathVariable Long id) {
        return detalleFacturaService.getDetalleFacturaById(id);
    }

    @PostMapping
    public DetalleFactura createDetalleFactura(@RequestBody DetalleFactura detalleFactura) {
        return detalleFacturaService.createDetalleFactura(detalleFactura);
    }

    @PutMapping("/{id}")
    public DetalleFactura updateDetalleFactura(@PathVariable Long id, @RequestBody DetalleFactura detalleFactura) {
        return detalleFacturaService.updateDetalleFactura(id, detalleFactura);
    }

    @DeleteMapping("/{id}")
    public void deleteDetalleFactura(@PathVariable Long id) {
        detalleFacturaService.deleteDetalleFactura(id);
    }

    



}
