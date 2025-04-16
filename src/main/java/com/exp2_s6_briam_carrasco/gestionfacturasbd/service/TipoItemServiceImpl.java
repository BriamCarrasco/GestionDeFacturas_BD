package com.exp2_s6_briam_carrasco.gestionfacturasbd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exp2_s6_briam_carrasco.gestionfacturasbd.model.TipoItem;
import com.exp2_s6_briam_carrasco.gestionfacturasbd.repository.TipoItemRepository;

@Service
public class TipoItemServiceImpl implements TipoItemService {

    @Autowired
    private TipoItemRepository tipoItemRepository;

    @Override
    public List<TipoItem> getAllTipoItems() {
        return tipoItemRepository.findAll();
    }

    @Override
    public Optional<TipoItem> getTipoItemById(Long id) {
        return tipoItemRepository.findById(id);
    }

    @Override
    public TipoItem createTipoItem(TipoItem tipoItem) {
        return tipoItemRepository.save(tipoItem);
    }

    @Override
    public void deleteTipoItem(Long id) {
        tipoItemRepository.deleteById(id);
    }

    @Override
    public TipoItem updateTipoItem(Long id, TipoItem tipoItem) {
        if (tipoItemRepository.existsById(id)) {
            tipoItem.setIdTipo(id);
            return tipoItemRepository.save(tipoItem);
        } else {
            return null; 
        }
    }
}
