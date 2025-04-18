package com.exp2_s6_briam_carrasco.gestionfacturasbd.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private Long idIdCliente;

    @NotNull(message = "El nombre del cliente no puede estar vacío")
    @Column(name = "NOMBRE_CLIENTE")
    private String nombreCliente;

    
    @Pattern(
    regexp = "^\\d{7,8}-[\\dkK]$",
    message = "El RUT debe tener el formato 12345678-5")
    @NotNull(message = "El RUT del cliente no puede estar vacío")
    @Column(name = "RUT_CLIENTE")
    private String rutCliente;

    @NotNull
    @Column(name = "DIRECCION_CLIENTE")
    private String direccionCliente;

    @NotNull
    @Pattern(
    regexp = "^\\+569\\s\\d{8}$",
    message = "El número debe tener el formato +569 12345678")
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
