package com.exp2_s6_briam_carrasco.gestionfacturasbd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private Long idIdCliente;

    @Column(name = "NOMBRE_CLIENTE")
    private String nombreCliente;

    @Column(name = "RUT_CLIENTE")
    private String rutCliente;

    @Column(name = "DIRECCION_CLIENTE")
    private String direccionCliente;

    @Column(name = "TELEFONO_CLIENTE")
    private String telefonoCliente;

    public Cliente(){

    }//Constructor vacio

    public Long getIdIdCliente() {
        return idIdCliente;
    }

    public void setIdIdCliente(Long idIdCliente) {
        this.idIdCliente = idIdCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    


    
}
