package com.exp2_s6_briam_carrasco.gestionfacturasbd.dto;

import lombok.Data;

@Data
public class DetalleFacturaDTO {
    private Long idDetalleFactura;
    private Long cantidad;
    private Double precioUnitario;
    private Double subtotal;
    private ItemDTO item;
}
