package com.exp2_s6_briam_carrasco.gestionfacturasbd.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "DETALLE_FACTURA")
public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DET_FACTURA")
    private Long idDetalleFactura;

    @NotNull
    @Column(name = "CANTIDAD")
    private Long cantidad;

    @NotNull
    @Column(name = "PRECIO_UNITARIO")
    private Double precioUnitario;

    @NotNull
    @Column(name = "SUBTOTAL")
    private Double subtotal;

    @ManyToOne
    @JoinColumn(name = "factura_id_factura")
    @JsonBackReference
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "item_id_item")
    private Item item;

    public DetalleFactura() {
    }//constructor vacio

    public Long getIdDetalleFactura() {
        return idDetalleFactura;
    }

    public void setIdDetalleFactura(Long idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }



    
}
