package com.exp2_s6_briam_carrasco.gestionfacturasbd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exp2_s6_briam_carrasco.gestionfacturasbd.model.Emisor;
import com.exp2_s6_briam_carrasco.gestionfacturasbd.service.EmisorService;

@RestController
@RequestMapping("/emisores")
@CrossOrigin(origins = "*")
public class EmisorController {

    @Autowired
    private EmisorService emisorService;

    @GetMapping
    public List<Emisor> getAllEmisores() {
        return emisorService.getAllEmisores();
    }

    @GetMapping("/{id}")
    public Optional<Emisor> getEmisorById(@PathVariable Long id) {
        return emisorService.getEmisorById(id);
    }

    @PostMapping
    public Emisor createEmisor(@RequestBody Emisor emisor) {
        return emisorService.createEmisor(emisor);
    }

    @PutMapping("/{id}")
    public Emisor updateEmisor(@PathVariable Long id, @RequestBody Emisor emisor) {
        return emisorService.updateEmisor(id, emisor);
    }

    @DeleteMapping("/{id}")
    public void deleteEmisor(@PathVariable Long id) {
        emisorService.deleteEmisor(id);
    }
    
}
