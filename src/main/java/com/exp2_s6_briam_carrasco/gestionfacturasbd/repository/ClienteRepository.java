package com.exp2_s6_briam_carrasco.gestionfacturasbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp2_s6_briam_carrasco.gestionfacturasbd.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
