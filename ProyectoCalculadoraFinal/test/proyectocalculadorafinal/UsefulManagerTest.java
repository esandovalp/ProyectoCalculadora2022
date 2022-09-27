/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package proyectocalculadorafinal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author abrahammartinezceron
 */
public class UsefulManagerTest {
    
    public UsefulManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of evaluacionPostfija method, of class UsefulManager.
     */
    @Test
    public void testEvaluacionPostfija() {
        System.out.println("evaluacionPostfija");
        PilaA<String> pila = null;
        double expResult = 0.0;
        double result = UsefulManager.evaluacionPostfija(pila);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of infijaPostFija method, of class UsefulManager.
     */
    @Test
    public void testInfijaPostFija() {
        System.out.println("infijaPostFija");
        String expresion = "";
        PilaA<String> expResult = null;
        PilaA<String> result = UsefulManager.infijaPostFija(expresion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class UsefulManager.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        UsefulManager.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
