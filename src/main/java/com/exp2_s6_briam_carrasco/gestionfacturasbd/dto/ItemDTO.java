package com.exp2_s6_briam_carrasco.gestionfacturasbd.dto;

import lombok.Data;

@Data
public class ItemDTO {
    private Long idItem;
    private String nombreItem;
    private String descripcionItem;
    private Double precioItem;
    private TipoItemDTO tipoItem;
}
