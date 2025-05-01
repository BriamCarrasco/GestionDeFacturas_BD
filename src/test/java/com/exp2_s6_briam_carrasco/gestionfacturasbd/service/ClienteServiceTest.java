package com.exp2_s6_briam_carrasco.gestionfacturasbd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.exp2_s6_briam_carrasco.gestionfacturasbd.model.Cliente;
import com.exp2_s6_briam_carrasco.gestionfacturasbd.repository.ClienteRepository;


@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @Mock
    private ClienteRepository clienteRepositoryMock;

    private Cliente cliente;
    
    @BeforeEach
    public void setUp() 
    {
        cliente = new Cliente();
        cliente.setNombreCliente("Patricio Estrella");
        cliente.setRutCliente("12589654-2");
        cliente.setDireccionCliente("Calle Caracola #120");
        cliente.setTelefonoCliente("+569 78451245");    
    }

    @AfterEach
    public void tearDown() 
    {
        cliente = null;
    }

    @Test
    @DisplayName("Test crear cliente")
    public void createClienteTest()
    {
        when(clienteRepositoryMock.save(any())).thenReturn(cliente);

        Cliente resultado = clienteService.createCliente(cliente);

        assertEquals("Patricio Estrella", resultado.getNombreCliente());
        
    }

    @Test
    @DisplayName("Test buscar cliente por ID")
    public void findByIdTest() 
    {
        when(clienteRepositoryMock.findById(1L)).thenReturn(java.util.Optional.of(cliente));

        Optional<Cliente> resultado = clienteService.getClienteById(1L);

        assertEquals("Patricio Estrella", resultado.get().getNombreCliente());
    }
    

    
}
