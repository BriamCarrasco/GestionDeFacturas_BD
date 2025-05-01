package com.exp2_s6_briam_carrasco.gestionfacturasbd.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exp2_s6_briam_carrasco.gestionfacturasbd.model.Item;
import com.exp2_s6_briam_carrasco.gestionfacturasbd.service.ItemService;

@RestController
@RequestMapping("/items")
@CrossOrigin(origins = "*")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public CollectionModel<EntityModel<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();

        List<EntityModel<Item>> itemResources = items.stream()
                .map(item -> EntityModel.of(item,
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ItemController.class).getItemById(item.getIdItem())).withSelfRel()))
                .collect(Collectors.toList());

        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ItemController.class).getAllItems());
        return CollectionModel.of(itemResources, linkTo.withRel("items"));
    }

    @GetMapping("/{id}")
    public EntityModel<Item> getItemById(@PathVariable Long id) {
        Optional<Item> item = itemService.getItemById(id);
        if (item.isPresent()) {
            return EntityModel.of(item.get(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ItemController.class).getItemById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ItemController.class).getAllItems()).withRel("all-items"));
        } else {
            throw new RuntimeException("Item no encontrado con id: " + id);
        }
    }

    @PostMapping
    public EntityModel<Item> createItem(@RequestBody Item item) {
        Item createdItem = itemService.createItem(item);
        return EntityModel.of(createdItem,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ItemController.class).getItemById(createdItem.getIdItem())).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ItemController.class).getAllItems()).withRel("all-items"));
    }

    @PutMapping("/{id}")
    public EntityModel<Item> updateItem(@PathVariable Long id, @RequestBody Item item) {
        Item updatedItem = itemService.updateItem(id, item);
        return EntityModel.of(updatedItem,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ItemController.class).getItemById(updatedItem.getIdItem())).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ItemController.class).getAllItems()).withRel("all-items"));
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }
    
    
}
