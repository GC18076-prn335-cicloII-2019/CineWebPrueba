/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.cweb.controller;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ues.occ.edu.sv.ingenieria.prn335.centities.Funcion;
import ues.occ.edu.sv.ingenieria.prn335.centities.Sala;

/**
 *
 * @author fernando
 */

@ExtendWith(MockitoExtension.class)
public class PruebaTest {


    /**
     * Test of tipoAsiento method, of class Prueba.
     * @throws java.lang.Exception
     */
    @Test
    public void testTipoAsiento() throws Exception {
        System.out.println("tipoAsiento");
        
        String caracteristica = "Reclinable";
        
        Prueba pr = new Prueba();
        
        EntityManager emMock = Mockito.mock(EntityManager.class);
        pr.setEm(emMock);
        
        Query qrMock = Mockito.mock(Query.class);
        Mockito.when(emMock.createQuery("SELECT s FROM Sala s JOIN s.asientoSalaList al JOIN al.asiento.atributoAsientoList at WHERE at.caracteristicaAsiento.caracteristica = :cs")).thenReturn(qrMock);
        List<Sala> expResult = new LinkedList<>();
        Mockito.when(qrMock.getResultList()).thenReturn(expResult);
        
        List<Sala> result = pr.tipoAsiento(caracteristica);
        
        Mockito.verify(emMock).createQuery("SELECT s FROM Sala s JOIN s.asientoSalaList al JOIN al.asiento.atributoAsientoList at WHERE at.caracteristicaAsiento.caracteristica = :cs");
        Mockito.verify(qrMock).getResultList();
        
        assertSame(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of funcionPorDirector method, of class Prueba.
     */
    /*@Test
    public void testFuncionPorDirector() throws Exception {
        System.out.println("funcionPorDirector");
        String director = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Prueba instance = (Prueba)container.getContext().lookup("java:global/classes/Prueba");
        List<Funcion> expResult = null;
        List<Funcion> result = instance.funcionPorDirector(director);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of salasPorFuncion method, of class Prueba.
     */
    /*@Test
    public void testSalasPorFuncion() throws Exception {
        System.out.println("salasPorFuncion");
        Date fecha = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Prueba instance = (Prueba)container.getContext().lookup("java:global/classes/Prueba");
        List<Sala> expResult = null;
        List<Sala> result = instance.salasPorFuncion(fecha);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
