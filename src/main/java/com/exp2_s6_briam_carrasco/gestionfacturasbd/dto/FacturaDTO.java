package com.exp2_s6_briam_carrasco.gestionfacturasbd.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class FacturaDTO {
    private Long idFactura;
    private Long numFactura;
    private LocalDate fechaEmision;
    private Double totalFactura;
    private ClienteDTO cliente;
    private EmisorDTO emisor;
    private List<DetalleFacturaDTO> detalles;
    
}
