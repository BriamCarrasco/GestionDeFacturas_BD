package com.exp2_s6_briam_carrasco.gestionfacturasbd.service;

import java.util.List;
import java.util.Optional;

import com.exp2_s6_briam_carrasco.gestionfacturasbd.model.TipoItem;

public interface TipoItemService {

    List<TipoItem> getAllTipoItems();
    Optional<TipoItem> getTipoItemById(Long id);
    TipoItem createTipoItem(TipoItem tipoItem);
    TipoItem updateTipoItem(Long id, TipoItem tipoItem);
    void deleteTipoItem(Long id);
    
    
}
