package com.exp2_s6_briam_carrasco.gestionfacturasbd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ITEM")
public class Item {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ITEM")
    private Long idItem;

    @Column(name = "NOMBRE_ITEM")
    private String nombreItem;

    @Column(name = "DESCRIPCION_ITEM")
    private String descripcionItem;
    
    @Column(name = "PRECIO_ITEM")
    private Double precioItem;

    @ManyToOne
    @JoinColumn(name = "tipo_item_id_tipo_item")
    private TipoItem tipoItem;

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

    public String getDescripcionItem() {
        return descripcionItem;
    }

    public void setDescripcionItem(String descripcionItem) {
        this.descripcionItem = descripcionItem;
    }

    public Double getPrecioItem() {
        return precioItem;
    }

    public void setPrecioItem(Double precioItem) {
        this.precioItem = precioItem;
    }

    public TipoItem getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(TipoItem tipoItem) {
        this.tipoItem = tipoItem;
    }



}
