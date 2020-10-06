/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hausuebung_3;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tamara
 */
public class ReadInFileTest {
    
    public ReadInFileTest() {
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

//    @Test
//    public void testReadFile() {
//        System.out.println("readFile");
//        ReadInFile instance = new ReadInFile();
//        List<Weapon> expResult = null;
//        List<Weapon> result = instance.readFile();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }

    @Test
    public void testComparator() {
        System.out.println("Comparator");
        int damgage_max = 17;
        
        ReadInFile instance = new ReadInFile();
        List<Weapon> weapons = instance.readFile();
        instance.Comparator(weapons);
        
        assertEquals(damgage_max,weapons.get(0).getDamage());
    }
    
}
