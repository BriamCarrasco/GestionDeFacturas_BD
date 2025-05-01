package com.exp2_s6_briam_carrasco.gestionfacturasbd.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
    public CollectionModel<EntityModel<TipoItem>> getAllTipoItems() {
        List<TipoItem> tipoItems = tipoItemService.getAllTipoItems();

        List<EntityModel<TipoItem>> tipoItemResources = tipoItems.stream()
                .map(tipoItem -> EntityModel.of(tipoItem,
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TipoItemController.class).getTipoItemById(tipoItem.getIdTipo())).withSelfRel()))
                .collect(Collectors.toList());

        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(TipoItemController.class).getAllTipoItems());
        return CollectionModel.of(tipoItemResources, linkTo.withRel("tipo-items"));
    }

    @GetMapping("/{id}")
    public EntityModel<TipoItem> getTipoItemById(@PathVariable Long id) {
        Optional<TipoItem> tipoItem = tipoItemService.getTipoItemById(id);
        if (tipoItem.isPresent()) {
            return EntityModel.of(tipoItem.get(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TipoItemController.class).getTipoItemById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TipoItemController.class).getAllTipoItems()).withRel("all-tipo-items"));
        } else {
            throw new RuntimeException("TipoItem no encontrado con id: " + id);
        }
    }

    @PostMapping
    public EntityModel<TipoItem> createTipoItem(@RequestBody TipoItem tipoItem) {
        TipoItem createdTipoItem = tipoItemService.createTipoItem(tipoItem);
        return EntityModel.of(createdTipoItem,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TipoItemController.class).getTipoItemById(createdTipoItem.getIdTipo())).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TipoItemController.class).getAllTipoItems()).withRel("all-tipo-items"));
    }

    @PutMapping("/{id}")
    public EntityModel<TipoItem> updateTipoItem(@PathVariable Long id, @RequestBody TipoItem tipoItem) {
        TipoItem updatedTipoItem = tipoItemService.updateTipoItem(id, tipoItem);
        return EntityModel.of(updatedTipoItem,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TipoItemController.class).getTipoItemById(updatedTipoItem.getIdTipo())).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TipoItemController.class).getAllTipoItems()).withRel("all-tipo-items"));
    }

    @DeleteMapping("/{id}")
    public void deleteTipoItem(@PathVariable Long id) {
        tipoItemService.deleteTipoItem(id);
    }

    
}
