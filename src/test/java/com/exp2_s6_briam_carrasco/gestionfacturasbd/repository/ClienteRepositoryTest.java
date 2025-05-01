package com.exp2_s6_briam_carrasco.gestionfacturasbd.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.exp2_s6_briam_carrasco.gestionfacturasbd.model.Cliente;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteRepositoryTest {
    @Autowired
    private ClienteRepository clienteRepository;

    private Cliente cliente;
    @BeforeEach
    public void setUp() {
        cliente = new Cliente();
        cliente.setNombreCliente("Lucho Miranda");
        cliente.setRutCliente("12345678-9");
        cliente.setDireccionCliente("Calle test 1313");
        cliente.setTelefonoCliente("+569 12124545");

    }

    @AfterEach
    public void tearDown() {
        clienteRepository.deleteAll();
    }


    @Test
    @DisplayName("Test crear cliente")
    public void CreateClienteTest()
    {

        Cliente resultado = clienteRepository.save(cliente);

        assertNotNull(resultado.getIdIdCliente());
        assertEquals("Lucho Miranda", resultado.getNombreCliente());

    }

    @DisplayName("Test buscar cliente por ID")
    @Test
    public void findByIdTest() 
    {
        Cliente guardado = clienteRepository.save(cliente);
        Optional<Cliente> encontrado = clienteRepository.findById(guardado.getIdIdCliente());

        assertTrue(encontrado.isPresent());
        assertEquals("Lucho Miranda", encontrado.get().getNombreCliente());
    }

    
}
