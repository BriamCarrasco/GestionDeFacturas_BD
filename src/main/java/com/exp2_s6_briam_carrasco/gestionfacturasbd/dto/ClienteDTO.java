package com.exp2_s6_briam_carrasco.gestionfacturasbd.dto;

import lombok.Data;

@Data
public class ClienteDTO {
    private Long idCliente;
    private String nombreCliente;
    private String rutCliente;
    private String direccionCliente;
    private String telefonoCliente;
}
