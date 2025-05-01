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

import com.exp2_s6_briam_carrasco.gestionfacturasbd.model.Emisor;
import com.exp2_s6_briam_carrasco.gestionfacturasbd.repository.EmisorRepository;

@ExtendWith(MockitoExtension.class)
public class EmisorServiceTest {

    @InjectMocks
    private EmisorServiceImpl emisorService;

    @Mock
    private EmisorRepository emisorRepositoryMock;

    private Emisor emisor;

    @BeforeEach
    public void setUp() {
        emisor = new Emisor();
        emisor.setNombreEmisor("Bob Esponja");
        emisor.setRutEmisor("12345678-9");
        emisor.setDireccionEmisor("Fondo de Bikini #1");
    }

    @AfterEach
    public void tearDown() {
        emisor = null;
    }

    @Test
    @DisplayName("Test crear emisor")
    public void createEmisorTest() {
        when(emisorRepositoryMock.save(any())).thenReturn(emisor);

        Emisor resultado = emisorService.createEmisor(emisor);

        assertEquals("Bob Esponja", resultado.getNombreEmisor());
    }

    @Test
    @DisplayName("Test buscar emisor por ID")
    public void findByIdTest() {
        when(emisorRepositoryMock.findById(1L)).thenReturn(Optional.of(emisor));

        Optional<Emisor> resultado = emisorService.getEmisorById(1L);

        assertEquals("Bob Esponja", resultado.get().getNombreEmisor());
    }
}
