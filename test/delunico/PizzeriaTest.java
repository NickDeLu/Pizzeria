/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delunico;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nicol
 */
public class PizzeriaTest {
    
    public PizzeriaTest() {
    }
   
    /**
     * Test of testmethod method, of class Pizzeria.
     */
    @Test
    public void testTestmethodGood() {
        System.out.println("testmethodGood");
        String str = "snake";
        Pizzeria instance = new Pizzeria();
        boolean expResult = true;
        boolean result = instance.testmethod(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
   
    }
    
}
