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

 @author Chase Knapp
 */
public class BankDatabaseTest
{
   
   public BankDatabaseTest()
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
    * Test of open method, of class BankDatabase.
    */
   @Test
   public void testOpen()
   {
      System.out.println("open");
      BankAccount bk = new BankAccount("myacct" , "mypin");
      BankDatabase instance = new BankDatabase();
      boolean expResult = true;
      boolean result = instance.open(bk);
      assertEquals(expResult, result);
   }
   @Test
   public void testOpen1()
   {
      System.out.println("open");
      BankAccount bk = new BankAccount("myacct" , "mypin");
      BankDatabase instance = new BankDatabase();
      boolean expResult = true;
      boolean result = instance.open(bk);
      assertEquals(expResult, result);
   }

   @Test
   public void testOpen2()
   {
      System.out.println("open");
      BankAccount bk = new BankAccount("myacct" , "mypin");
      BankDatabase instance = new BankDatabase();
      boolean expResult = true;
      boolean result = instance.open(bk);
      assertEquals(expResult, result);
   }
   @Test
   public void testOpen3()
   {
      System.out.println("open");
      BankAccount bk = new BankAccount("myacct" , "mypin");
      BankDatabase instance = new BankDatabase();
      boolean expResult = true;
      boolean result = instance.open(bk);
      assertEquals(expResult, result);
   }
   @Test
   public void testOpen4()
   {
      System.out.println("open");
      BankAccount bk = new BankAccount("myacct" , "mypin");
      BankDatabase instance = new BankDatabase();
      boolean expResult = true;
      boolean result = instance.open(bk);
      assertEquals(expResult, result);
   }

   /**
    * Test of close method, of class BankDatabase.
    */
   @Test
   public void testClose()
   {
      System.out.println("close");
      BankAccount bk = new BankAccount("myAcct" , "mypin");
      BankDatabase instance = new BankDatabase();
      boolean expResult = true;
      instance.open(bk);
      boolean result = instance.close(bk);
      assertEquals(expResult, result);
   }
   @Test
   public void testClose1()
   {
      System.out.println("close");
      BankAccount bk = new BankAccount("myAcct" , "mypin");
      BankDatabase instance = new BankDatabase();
      boolean expResult = false;
      boolean result = instance.close(bk);
      assertEquals(expResult, result);
   }

   /**
    * Test of balance method, of class BankDatabase.
    */
   @Test
   public void testBalance()
   {
      System.out.println("balance");
      BankAccount bk = new BankAccount("myAcct" , "mypin");
      BankDatabase instance = new BankDatabase();
      instance.deposit(bk);
      int expResult = 0;
      int result = instance.balance(bk);
      assertEquals(expResult, result);
   }

   /**
    * Test of deposit method, of class BankDatabase.
    */
   @Test
   public void testDeposit()
   {
      System.out.println("deposit");
      BankAccount bk = new BankAccount("myAcct" , "mypin");
      BankDatabase instance = new BankDatabase();
      instance.open(bk);
      boolean expResult = true;
      boolean result = instance.deposit(bk);
      assertEquals(expResult, result);
   }
   @Test
   public void testDeposit1()
   {
      System.out.println("deposit");
      BankAccount bk = new BankAccount("myAcct" , "mypin");
      BankDatabase instance = new BankDatabase();
      boolean expResult = false;
      boolean result = instance.deposit(bk);
      assertEquals(expResult, result);
   }

   /**
    * Test of withdraw method, of class BankDatabase.
    */
   @Test
   public void testWithdraw()
   {
      System.out.println("withdraw");
      BankAccount bk = new BankAccount("myAcct" , "mypin");
      BankDatabase instance = new BankDatabase();
      int expResult = 0;
      instance.open(bk);
      int result = instance.withdraw(bk);
      assertEquals(expResult, result);
   }
   
   @Test
   public void testWithdraw1()
   {
      System.out.println("withdraw");
      BankAccount bk = new BankAccount("myAcct" , "mypin");
      BankDatabase instance = new BankDatabase();
      int expResult = -1;
      int result = instance.withdraw(bk);
      assertEquals(expResult, result);
   }

   /**
    * Test of print method, of class BankDatabase.
    */
   @Test
   public void testPrint()
   {
      System.out.println("print");
      BankAccount bk = new BankAccount("myAcct" , "mypin");
      BankAccount bk1 = new BankAccount("myAcct1" , "mypin1");
      BankAccount bk2 = new BankAccount("myAcct2" , "mypin2");
      BankDatabase instance = new BankDatabase();
      instance.open(bk);
      instance.open(bk1);
      instance.open(bk2);
      instance.print();
   }

   /**
    * Test of contains method, of class BankDatabase.
    */
   @Test
   public void testContains()
   {
      System.out.println("contains");
      BankAccount bk = new BankAccount("myAcct" , "mypin");
      BankDatabase instance = new BankDatabase();
      boolean expResult = false;
      boolean result = instance.contains(bk);
      assertEquals(expResult, result);
   }
   @Test
   public void testContains1()
   {
      System.out.println("contains");
      BankAccount bk = new BankAccount("myAcct" , "mypin");
      BankDatabase instance = new BankDatabase();
      boolean expResult = true;
      instance.open(bk);
      boolean result = instance.contains(bk);
      assertEquals(expResult, result);
   }
}
