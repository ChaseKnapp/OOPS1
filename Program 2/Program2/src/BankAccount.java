
import java.util.StringTokenizer;

/**
 Class that holds the data of a given bank account. 
 Bank accounts have a name, pin, and balance. Account read in from string.
 @author Chase Knapp
 */

public class BankAccount
{
 private String account;
 private String pin;
 private int balance;

   /**
    * Bank account constructor
    * @param acctno account no to set account to
    * @param pn pin to set pin to
    */
   public BankAccount(String acctno, String pn)
 {
    account = acctno;
    pin = pn;
    balance = 0;
 }

   /**
    * Sets data values to bank account from string
    * @param acct string with name, pin, and balance separated by |
    */
   public BankAccount(String acct)
 {
    StringTokenizer st = new StringTokenizer(acct,"|" );
    account = st.nextToken();
    pin = st.nextToken();
    balance = Integer.parseInt(st.nextToken());
 }

   /**
    * Returns the account number of the account.
    * @return account
    */
   public String getAccount()
 {
    return account;
 }

   /**
    * Returns the balance of the account.
    * @return ballance
    */
   public int getBalance()
 {
    return balance;
 }

   /**
    * If balance is greater than amount subtracts amount from balance.
    * @param amount amount to withdraw
    * @return true if balance > amount false if not. 
    */
   public boolean debit(int amount)
 {
    if( balance > amount)
    {
       balance = balance - amount;
       return true;
    }
    return false;
 }

   /**
    * Adds amount to balance.
    * @param amount amount to add the the balance.
    */
   public void credit(int amount)
 {
    balance = balance + amount;
 }

   /**
    * Checks if given bank account is equal to bankAccount
    * @param obj the bank account that is being checked
    * @return true if they are equal false if they are not. 
    */
   public boolean equals(Object obj)
 {
    if( obj instanceof BankAccount)
    {
      BankAccount b = (BankAccount) obj;
      return account.equals(b.account) && pin.equals(b.pin);
    }
    return false;
 }

   /**
    * Creates a string of account and balance. 
    * @return the string of account and balance.
    */
   public String toString()
 {
    return account + ", " + balance; 
 }

   /**
    * Testbed main. 
    * @param Args
    */
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
