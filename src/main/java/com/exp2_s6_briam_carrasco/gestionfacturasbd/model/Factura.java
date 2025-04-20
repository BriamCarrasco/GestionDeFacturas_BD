package com.exp2_s6_briam_carrasco.gestionfacturasbd.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "FACTURA")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FACTURA")
    private Long idFactura;

    @Size(min=4)
    @NotNull
    @Column(name = "NUM_FACTURA")
    private Long numFactura;
    
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "FECHA_EMISION")
    private LocalDate fechaEmision;

    @NotNull
    @Column(name = "TOTAL_FACTURA")
    private Double totalFactura;

    @NotNull(message= "El cliente no puede ser nulo")
    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID_CLIENTE")
    private Cliente cliente;

    @NotNull(message= "El emisor no puede ser nulo")
    @ManyToOne
    @JoinColumn(name = "EMISOR_ID_EMISOR")
    private Emisor emisor;


    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<DetalleFactura> detalles = new ArrayList<>();

    public Factura() {
    }//constructor vacio

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public Long getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(Long numFactura) {
        this.numFactura = numFactura;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Double getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(Double totalFactura) {
        this.totalFactura = totalFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Emisor getEmisor() {
        return emisor;
    }

    public void setEmisor(Emisor emisor) {
        this.emisor = emisor;
    }

    public List<DetalleFactura> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleFactura> detalles) {
        this.detalles = detalles;
    }





}
