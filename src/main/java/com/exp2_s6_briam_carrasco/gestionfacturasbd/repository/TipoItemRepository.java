package com.exp2_s6_briam_carrasco.gestionfacturasbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp2_s6_briam_carrasco.gestionfacturasbd.model.TipoItem;

public interface TipoItemRepository extends JpaRepository<TipoItem, Long> {
    // Aquí puedes agregar métodos específicos para la entidad TipoItem si es necesario
    
}
