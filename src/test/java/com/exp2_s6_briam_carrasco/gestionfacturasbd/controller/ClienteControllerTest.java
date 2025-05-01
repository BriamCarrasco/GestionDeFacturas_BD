package com.exp2_s6_briam_carrasco.gestionfacturasbd.controller;

import static org.mockito.Mockito.when;

import java.util.List;


import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Arrays;

import com.exp2_s6_briam_carrasco.gestionfacturasbd.model.Cliente;
import com.exp2_s6_briam_carrasco.gestionfacturasbd.service.ClienteServiceImpl;

@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ClienteServiceImpl clienteServiceMock;

    private Cliente cliente1;
    private Cliente cliente2;

    @BeforeEach
    public void setUp() {
        cliente1 = new Cliente();
        cliente1.setIdIdCliente(1L);
        cliente1.setNombreCliente("Violeta Parra");
        cliente1.setRutCliente("11111111-1");
        cliente1.setDireccionCliente("Calle Falsa 123");
        cliente1.setTelefonoCliente("+569 12345678");

        cliente2 = new Cliente();
        cliente2.setIdIdCliente(2L);
        cliente2.setNombreCliente("Pablo Neruda");
        cliente2.setRutCliente("2222222-2");
        cliente2.setDireccionCliente("Calle Verdadera 321");
        cliente2.setTelefonoCliente("+569 87654321"); 
    }

    @Test
    public void getAllClientes() throws Exception
    {
        List<Cliente> clientes = Arrays.asList(cliente1, cliente2);
        when(clienteServiceMock.getAllClientes()).thenReturn(clientes);
        mockMvc.perform(MockMvcRequestBuilders.get("/clientes"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.clienteList", Matchers.hasSize(2)))
            .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.clienteList[0].nombreCliente").value("Violeta Parra"))
            .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.clienteList[1].nombreCliente").value("Pablo Neruda"))
            .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.clienteList[0].rutCliente").value("11111111-1"))
            .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.clienteList[1].rutCliente").value("2222222-2"))
            .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.clienteList[0].direccionCliente").value("Calle Falsa 123"))
            .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.clienteList[1].direccionCliente").value("Calle Verdadera 321"))
            .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.clienteList[0].telefonoCliente").value("+569 12345678"))
            .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.clienteList[1].telefonoCliente").value("+569 87654321"));

    }
    
    
}
