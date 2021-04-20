/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author XeroFox
 */
public class CasinoBoltControllerTest {
    
    public CasinoBoltControllerTest() {
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
     * Test of KepDataCsere method, of class CasinoBoltController.
     */
    @Test
    public void testKepDataCsere() {
        System.out.println("KepDataCsere");
        String[] Kellekek = new String[] {"2","1","0","1"};
        int kellek = 3;
        CasinoBoltController instance = new CasinoBoltController();
        String[] expResult = new String[] {"1","1","0","2"};
        String[] result = instance.KepDataCsere(Kellekek, kellek);
        assertArrayEquals(expResult, result);
    }
    
}
