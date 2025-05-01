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

import com.exp2_s6_briam_carrasco.gestionfacturasbd.model.Cliente;
import com.exp2_s6_briam_carrasco.gestionfacturasbd.model.Emisor;
import com.exp2_s6_briam_carrasco.gestionfacturasbd.service.EmisorService;

@RestController
@RequestMapping("/emisores")
@CrossOrigin(origins = "*")
public class EmisorController {

    @Autowired
    private EmisorService emisorService;


    @GetMapping
    public CollectionModel<EntityModel<Emisor>> getAllEmisores() {
        List<Emisor> emisores = emisorService.getAllEmisores();

        List<EntityModel<Emisor>> emisorResources = emisores.stream()
                .map(emisor -> EntityModel.of(emisor,
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmisorController.class).getEmisorById(emisor.getIdEmisor())).withSelfRel()))
                .collect(Collectors.toList());

        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmisorController.class).getAllEmisores());
        CollectionModel<EntityModel<Emisor>> resources = CollectionModel.of(emisorResources, linkTo.withRel("emisores"));

        return resources;
    }

    @GetMapping("/{id}")
    public EntityModel<Emisor> getEmisorById(@PathVariable Long id) {
        Optional<Emisor> emisor = emisorService.getEmisorById(id);
        if (emisor.isPresent()) {
            return EntityModel.of(emisor.get(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmisorController.class).getEmisorById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmisorController.class).getAllEmisores()).withRel("all-emisores"));
        } else {
            throw new RuntimeException("Emisor no encontrado con id: " + id);
        }
    }

    @PostMapping
    public EntityModel<Emisor> createEmisor(@RequestBody Emisor emisor) {
        Emisor createdEmisor = emisorService.createEmisor(emisor);
        return EntityModel.of(createdEmisor,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmisorController.class).getEmisorById(createdEmisor.getIdEmisor())).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmisorController.class).getAllEmisores()).withRel("all-emisores"));
    }

    @PutMapping("/{id}")
    public EntityModel<Emisor> updateEmisor(@PathVariable Long id, @RequestBody Emisor emisor) {
        Emisor updatedEmisor = emisorService.updateEmisor(id, emisor);
        return EntityModel.of(updatedEmisor,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmisorController.class).getEmisorById(updatedEmisor.getIdEmisor())).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmisorController.class).getAllEmisores()).withRel("all-emisores"));
    }

    @DeleteMapping("/{id}")
    public void deleteEmisor(@PathVariable Long id) {
        emisorService.deleteEmisor(id);
    }
}

    

