/**
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
*/

/**
 
 @author Chase Knapp
 */
import java.util.StringTokenizer;
public class BankAccount
{
 private String account;
 private String pin;
 private int balance;

 public BankAccount(String acctno, String pn)
 {
    account = acctno;
    pin = pn;
    balance = 0;
 }//constructor; initialize balance to 0;
 public BankAccount(String acct)
 {
    StringTokenizer st = new StringTokenizer(acct," " );
 }//constructor; parse acct into 3 tokens
 public String getAccount()
 {
    return account;
 }//return the account
 public int getBalance()
 {
    return balance;
 }//return the balance
 public boolean debit(int amount)
 {
    if( balance >= amount)
    {
       balance = balance - amount;
       return true;
    }
    return false;
 }//subtract amount from balance if balance >= amount
 public void credit(int amount)
 {
    balance = balance + amount;
 }//add amount to balance
 public boolean equals(Object obj)
 {
    if( obj instanceof BankAccount)
    {
      BankAccount b = (BankAccount) obj;
      return account.equals( b.account) && pin.equals( b.pin);
    }
    return false;
 }//two accounts are equal if IDs and PINs are the same
 public String toString()
 {
    return "Account " + account + ", balance " + balance; 
 }//return a single string with account, balance.
 public static void main( String Args[] )
 {
    BankAccount b = new BankAccount("Chase","123");
    System.out.println("getAccount");
    String expResult = "Chase";
    String result = b.getAccount();
    if ( result.equals(expResult))
       System.out.println(true);
    else
       System.out.println(false);
    System.out.println("getBalance");
    int expResult1 = 0;
    int result1 = b.getBalance();
    if ( result1 == expResult1)
       System.out.println(true);
    else
       System.out.println(false);
    System.out.println("debit");
    b.balance = 0;
    int amount = -5;
    boolean expResult2 = true;
    boolean result2 = b.debit(amount);
    if( result2 == expResult2 )
       System.out.println(true);
    else
       System.out.println(false); 
    b.balance = 0;
    amount = 5;
    expResult2 = false;
    result2 = b.debit(amount);
    if( result2 == expResult2 )
       System.out.println(true);
    else
       System.out.println(false);
    System.out.println("credit");
    amount = -1;
    BankAccount c = new BankAccount("Chase","123");
    c.credit(amount);
    System.out.println(c.balance);
    System.out.println("equals");
    Object obj = null;
    expResult2 = false;
    result2 = c.equals(obj);
    if( result2 == expResult2 )
       System.out.println(true);
    else
       System.out.println(false);
 }
} //end of BankAccount class 
