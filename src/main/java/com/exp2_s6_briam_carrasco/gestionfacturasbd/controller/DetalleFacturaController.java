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

import com.exp2_s6_briam_carrasco.gestionfacturasbd.model.DetalleFactura;
import com.exp2_s6_briam_carrasco.gestionfacturasbd.service.DetalleFacturaService;

@RestController
@RequestMapping("/detallefactura")
@CrossOrigin(origins = "*")
public class DetalleFacturaController {
    
    @Autowired
    private DetalleFacturaService  detalleFacturaService;

        @GetMapping
    public CollectionModel<EntityModel<DetalleFactura>> getAllDetallesFactura() {
        List<DetalleFactura> detalles = detalleFacturaService.getAllDetallesFactura();

        List<EntityModel<DetalleFactura>> detalleResources = detalles.stream()
                .map(detalle -> EntityModel.of(detalle,
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DetalleFacturaController.class).getDetalleFacturaById(detalle.getIdDetalleFactura())).withSelfRel()))
                .collect(Collectors.toList());

        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DetalleFacturaController.class).getAllDetallesFactura());
        return CollectionModel.of(detalleResources, linkTo.withRel("detalles-factura"));
    }

    @GetMapping("/{id}")
    public EntityModel<DetalleFactura> getDetalleFacturaById(@PathVariable Long id) {
        Optional<DetalleFactura> detalle = detalleFacturaService.getDetalleFacturaById(id);
        if (detalle.isPresent()) {
            return EntityModel.of(detalle.get(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DetalleFacturaController.class).getDetalleFacturaById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DetalleFacturaController.class).getAllDetallesFactura()).withRel("all-detalles-factura"));
        } else {
            throw new RuntimeException("DetalleFactura no encontrado con id: " + id);
        }
    }

    @PostMapping
    public EntityModel<DetalleFactura> createDetalleFactura(@RequestBody DetalleFactura detalleFactura) {
        DetalleFactura created = detalleFacturaService.createDetalleFactura(detalleFactura);
        return EntityModel.of(created,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DetalleFacturaController.class).getDetalleFacturaById(created.getIdDetalleFactura())).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DetalleFacturaController.class).getAllDetallesFactura()).withRel("all-detalles-factura"));
    }

    @PutMapping("/{id}")
    public EntityModel<DetalleFactura> updateDetalleFactura(@PathVariable Long id, @RequestBody DetalleFactura detalleFactura) {
        DetalleFactura updated = detalleFacturaService.updateDetalleFactura(id, detalleFactura);
        return EntityModel.of(updated,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DetalleFacturaController.class).getDetalleFacturaById(updated.getIdDetalleFactura())).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DetalleFacturaController.class).getAllDetallesFactura()).withRel("all-detalles-factura"));
    }

    @DeleteMapping("/{id}")
    public void deleteDetalleFactura(@PathVariable Long id) {
        detalleFacturaService.deleteDetalleFactura(id);
    }
}

    



