package com.exp2_s6_briam_carrasco.gestionfacturasbd.model;


import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "EMISOR")
public class Emisor extends RepresentationModel<Emisor> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EMISOR")
    private Long idEmisor;

    @NotNull(message = "El RUT no puede ser nulo")
    @Column(name = "RUT_EMISOR")
    private String rutEmisor;   

    @NotNull(message =  "El nombre no puede ser nulo")
    @Column(name = "NOMBRE_EMISOR")
    private String nombreEmisor;

    @NotNull (message = "La dirección no puede ser nula")
    @Size(max = 100, min=15, message = "La dirección debe tener entre 15 y 100 caracteres")
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñÜü0-9\\s]+ #\\d+$",
    message = "La dirección debe tener el formato Calle #Número")
    @Column(name = "DIRECCION_EMISOR")
    private String direccionEmisor;

    public Emisor() {
    }

    public Long getIdEmisor() {
        return idEmisor;
    }

    public void setIdEmisor(Long idEmisor) {
        this.idEmisor = idEmisor;
    }

    public String getRutEmisor() {
        return rutEmisor;
    }

    public void setRutEmisor(String rutEmisor) {
        this.rutEmisor = rutEmisor;
    }

    public String getNombreEmisor() {
        return nombreEmisor;
    }

    public void setNombreEmisor(String nombreEmisor) {
        this.nombreEmisor = nombreEmisor;
    }

    public String getDireccionEmisor() {
        return direccionEmisor;
    }

    public void setDireccionEmisor(String direccionEmisor) {
        this.direccionEmisor = direccionEmisor;
    }

}
