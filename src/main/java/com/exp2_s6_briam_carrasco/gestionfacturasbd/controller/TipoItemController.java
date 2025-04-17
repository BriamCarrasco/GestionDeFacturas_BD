package com.exp2_s6_briam_carrasco.gestionfacturasbd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exp2_s6_briam_carrasco.gestionfacturasbd.model.TipoItem;
import com.exp2_s6_briam_carrasco.gestionfacturasbd.service.TipoItemService;

@RestController
@RequestMapping("/tipoitems")
public class TipoItemController {

    @Autowired
    private TipoItemService tipoItemService;

    @GetMapping
    public List<TipoItem> getAllTipoItems() {
        return tipoItemService.getAllTipoItems();
    }

    @GetMapping("/{id}")
    public Optional<TipoItem> getTipoItemById(@PathVariable Long id) {
        return tipoItemService.getTipoItemById(id);
    }

    @PostMapping
    public TipoItem createTipoItem(@RequestBody TipoItem tipoItem) {
        return tipoItemService.createTipoItem(tipoItem);
    }

    @PutMapping("/{id}")
    public TipoItem updateTipoItem(@PathVariable Long id, @RequestBody TipoItem tipoItem) {
        return tipoItemService.updateTipoItem(id, tipoItem);
    }

    @DeleteMapping("/{id}")
    public void deleteTipoItem(@PathVariable Long id) {
        tipoItemService.deleteTipoItem(id);
    }



    
}
