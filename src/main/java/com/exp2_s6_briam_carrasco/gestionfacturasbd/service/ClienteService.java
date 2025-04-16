package com.exp2_s6_briam_carrasco.gestionfacturasbd.service;

import java.util.List;
import java.util.Optional;


import com.exp2_s6_briam_carrasco.gestionfacturasbd.model.Cliente;

public interface ClienteService {
    List<Cliente> getAllClientes();
    Optional<Cliente> getClienteById(Long id);
    Cliente createCliente(Cliente cliente);
    Cliente updateCliente(Long id, Cliente cliente);
    void deleteCliente(Long id);

    
}
