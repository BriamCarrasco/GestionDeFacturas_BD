package com.exp2_s6_briam_carrasco.gestionfacturasbd.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.exp2_s6_briam_carrasco.gestionfacturasbd.model.Emisor;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmisorRepositoryTest {
    @Autowired
    private EmisorRepository emisorRepository;

    private Emisor emisor;

    @BeforeEach
    public void setUp() {
        emisor = new Emisor();
        emisor.setRutEmisor("12345678-9");
        emisor.setNombreEmisor("Luis Pinto");
        emisor.setDireccionEmisor("Calle test #1313");
    }

    @AfterEach
    public void tearDown() {
        emisorRepository.deleteAll();
    }

    @Test
    public void createEmisorTest() {
        Emisor resultado = emisorRepository.save(emisor);

        assertNotNull(resultado.getIdEmisor());
        assertEquals("Luis Pinto", resultado.getNombreEmisor());
    }

    @Test
    public void findByIdTest() {
        Emisor guardado = emisorRepository.save(emisor);
        Emisor encontrado = emisorRepository.findById(guardado.getIdEmisor()).orElse(null);

        assertNotNull(encontrado);
        assertEquals("Luis Pinto", encontrado.getNombreEmisor());
    }

    


}
