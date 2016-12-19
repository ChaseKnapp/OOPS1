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
public class BankAccountTest
{
   
   public BankAccountTest()
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
    * Test of getAccount method, of class BankAccount.
    */
   @Test
   public void testGetAccount()
   {
      System.out.println("getAccount");
      BankAccount instance = null;
      String expResult = "";
      String result = instance.getAccount();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of getBalance method, of class BankAccount.
    */
   @Test
   public void testGetBalance()
   {
      System.out.println("getBalance");
      BankAccount instance = null;
      int expResult = 0;
      int result = instance.getBalance();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of debit method, of class BankAccount.
    */
   @Test
   public void testDebit()
   {
      System.out.println("debit");
      int amount = 0;
      BankAccount instance = null;
      boolean expResult = false;
      boolean result = instance.debit(amount);
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of credit method, of class BankAccount.
    */
   @Test
   public void testCredit()
   {
      System.out.println("credit");
      int amount = 0;
      BankAccount instance = null;
      instance.credit(amount);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of equals method, of class BankAccount.
    */
   @Test
   public void testEquals()
   {
      System.out.println("equals");
      Object obj = null;
      BankAccount instance = null;
      boolean expResult = false;
      boolean result = instance.equals(obj);
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of toString method, of class BankAccount.
    */
   @Test
   public void testToString()
   {
      System.out.println("toString");
      BankAccount instance = null;
      String expResult = "";
      String result = instance.toString();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }
   
}
