package com.exp2_s6_briam_carrasco.gestionfacturasbd.controller;

import java.util.Collection;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.exp2_s6_briam_carrasco.gestionfacturasbd.model.Cliente;
import com.exp2_s6_briam_carrasco.gestionfacturasbd.service.ClienteService;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;



    @GetMapping
    public CollectionModel<EntityModel<Cliente>> getAllClientes() {
        List<Cliente> clientes = clienteService.getAllClientes();

        List<EntityModel<Cliente>> clienteResources = clientes.stream()
                .map(cliente -> EntityModel.of(cliente,
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getClienteById(cliente.getIdIdCliente())).withSelfRel()))
                .collect(Collectors.toList());
        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllClientes());
        CollectionModel<EntityModel<Cliente>> resources = CollectionModel.of(clienteResources, linkTo.withRel("clientes"));

        return resources;
    }

    @GetMapping("/{id}")
    public EntityModel<Cliente> getClienteById(@PathVariable Long id)
    {
        Optional<Cliente> cliente = clienteService.getClienteById(id);
        if (cliente.isPresent())
        {
            return EntityModel.of(cliente.get(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getClienteById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllClientes()).withRel("all-clientes"));
        }else
        {
            throw new RuntimeException("Cliente no encontrado con id: " + id);
        }
    }

    @PostMapping
    public EntityModel<Cliente> createCliente(@RequestBody Cliente cliente)
    {
        Cliente createCliente = clienteService.createCliente(cliente);
        return EntityModel.of(createCliente,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getClienteById(createCliente.getIdIdCliente())).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllClientes()).withRel("all-clientes"));
    }
    
    @PutMapping("/{id}")
    public EntityModel<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente)
    {
       Cliente updateCliente = clienteService.updateCliente(id, cliente);
       return EntityModel.of(updateCliente,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getClienteById(updateCliente.getIdIdCliente())).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllClientes()).withRel("all-clientes"));
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id)
    {
        clienteService.deleteCliente(id);
    }

    


    /* 
    
    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteService.createCliente(cliente);
    }

    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.updateCliente(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
    }
    */
    
    
}
