package org.dgac.cl.model.entity;

import java.util.List;

import org.dgac.cl.model.service.CompaniaAereaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class CompaniaAereaServiceIntegrationTest {

    @Autowired
    private CompaniaAereaService companiaAereaService;

    @Test
    public void testFindOrCreateCompania() {
        List<CompaniaAerea> resultado = companiaAereaService.findByNombre("prueba");
        System.out.println(resultado);
        
        // Verifica el resultado, por ejemplo, asegurándote de que la lista no esté vacía
        assert resultado != null; // Puedes reemplazar con otras validaciones según tu necesidad
    }
}
