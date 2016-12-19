/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**

 @author knapp_000
 */
public class ComplexTest
{
   
   public ComplexTest()
   {
   }
   
   @BeforeClass
   public static void setUpClass()
   {
   }
   
   @AfterClass
   public static void tearDownClass()
   {
   }
   
   @Before
   public void setUp()
   {
   }
   
   @After
   public void tearDown()
   {
   }

   /**
    * Test of plus method, of class Complex.
    */
   @Test
   public void testPlus()
   {
      System.out.println("plus");
      Complex cp = new Complex(5);
      Complex instance = new Complex(4);
      Complex expResult = new Complex(9);
      Complex result = instance.plus(cp);
      assertEquals(expResult, result);
      System.out.println(result);
      System.out.println("plus2");
      Complex cp2 = new Complex(5,0);
      Complex instance2 = new Complex(0,1);
      Complex expResult2 = new Complex(5,1);
      Complex result2 = instance2.plus(cp2);
      assertEquals(expResult2, result2);
      System.out.println(result2);
   }

   /**
    * Test of minus method, of class Complex.
    */
   @Test
   public void testMinus()
   {
      System.out.println("minus");
      Complex cp = new Complex(3);
      Complex instance = new Complex(4);
      Complex expResult = new Complex(1);
      Complex result = instance.minus(cp);
      assertEquals(expResult, result);
      System.out.println(result);
      System.out.println("minus2");
      Complex cp2 = new Complex(3);
      Complex instance2 = new Complex(2);
      Complex expResult2 = new Complex(-1);
      Complex result2 = instance2.minus(cp2);
      assertEquals(expResult2, result2);
      System.out.println(result2);
      System.out.println("minus3");
      Complex cp3 = new Complex(3,2);
      Complex instance3 = new Complex(5,1);
      Complex expResult3 = new Complex(2,-1);
      Complex result3 = instance3.minus(cp3);
      assertEquals(expResult3, result3);
      System.out.println(result3);
   }

   /**
    * Test of times method, of class Complex.
    */
   @Test
   public void testTimes()
   {
      System.out.println("times");
      Complex cp = new Complex (2,3);
      Complex instance = new Complex(4,2);
      Complex expResult = new Complex (14,16);
      Complex result = instance.times(cp);
      assertEquals(expResult, result);
      Complex cp2 = new Complex (2,-1);
      Complex instance2 = new Complex (3,2);
      Complex expResult2 = new Complex (4,1);
      Complex result2 = instance2.times(cp2);
      assertEquals(expResult2, result2);
   }

   /**
    * Test of conjugate method, of class Complex.
    */
   @Test
   public void testConjugate()
   {
      System.out.println("conjugate");
      Complex cp = new Complex (2, 1);
      Complex expResult = new Complex (2, -1);
      Complex result = cp.conjugate();
      assertEquals(expResult, result);
      Complex cp2 = new Complex (2,-1);
      Complex expResult2 = new Complex (2,1);
      Complex result2 = cp2.conjugate();
      assertEquals(expResult2, result2);
   }

   /**
    * Test of equals method, of class Complex.
    */
   @Test
   public void testEquals()
   {
      System.out.println("equals");
      Complex cp = new Complex(3);
      Complex instance = new Complex(4);
      boolean expResult = false;
      boolean result = instance.equals(cp);
      assertEquals(expResult, result);
      Complex cp2 = new Complex(2,2);
      Complex instance2 = new Complex (2,2);
      boolean expResult2 = true;
      boolean result2 = instance2.equals(cp2);
      assertEquals(expResult2,result2);
   }

   /**
    * Test of toString method, of class Complex.
    */
   @Test
   public void testToString()
   {
      System.out.println("toString");
      Complex instance = new Complex (0);
      String expResult = "0";
      String result = instance.toString();
      assertEquals(expResult, result);
      Complex instance2 = new Complex (5,0);
      String expResult2 = "5";
      String result2 = instance2.toString();
      assertEquals(expResult2, result2);
      Complex instance3 = new Complex (7, +-3);
      String expResult3 = "7-3";
      String result3 = instance3.toString();
      assertEquals(expResult3, result3);
      Complex instance4 = new Complex ( 0, 1);
      String expResult4 = "i";
      String result4 = instance4.toString();
      assertEquals(expResult4, result4);
      Complex instance5 = new Complex ( 0, -1);
      String expResult5 = "-i";
      String result5 = instance5.toString();
      System.out.println(result5);
      assertEquals(expResult5, result5);
   }
   
}
