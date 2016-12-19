
/**
 Bank Database contains an array of Bank Accounts.
 Has methods for finding accounts, removing, adding, and editing. 
 @author Chase Knapp
 */
public class BankDatabase
{
   private final static int GROW_SIZE = 4;
   private BankAccount [] bankDB;
   private int numAcct;

   /**
    * Constructor for the bank database. 
    * Creates an array of bankAccounts.
    */
   public BankDatabase()
   {
      bankDB = new BankAccount[GROW_SIZE];
      numAcct = 0;
   }
   
   /**
   * Finds index of given account
   @param bk bank account to find
   @return index of account if found, -1 if not
   */
   private int find(BankAccount bk)
   {
      for ( int i = 0; i < numAcct; i++)
         if ( bk.equals(bankDB[i] ) )
            return i;
      return -1;
   }
   
   /**
   * Grows the array by GROW_SIZE
   */
   private void grow()
   {
      BankAccount newList[] = new BankAccount[bankDB.length + GROW_SIZE];
      for ( int i = 0; i < numAcct; i++ )
      newList[i] = bankDB[i];
      bankDB = newList;
   }

   /**
    * Adds a bank account if not found
    * Does not add if found in list
    * @param bk account to open
    * @return True if added false if not
    */
   public boolean open(BankAccount bk)
   {
      if ( contains(bk) == false )
      {
         if ( numAcct == bankDB.length )
            grow();
         bankDB[numAcct++] = bk;
         return true;
      }
      return false;
   }

   /**
    * Closes bank account if found
    * Does nothing if not found
    * @param bk account to close
    * @return true if closed false if not
    */
   public boolean close(BankAccount bk)
   {
      if ( contains(bk) )
      {
         bankDB[find(bk)] = bankDB[--numAcct];
         return true;
      }
      return false;
   }

   /**
    * Returns bank account balance if found
    * Does nothing if not found
    * @param bk bank account to return balance
    * @return balance if found 0 if not
    */
   public int balance(BankAccount bk)
   {
      if ( contains(bk) )
      {
         return bankDB[find(bk)].getBalance();
      }
      return 0;
   }

   /**
    * Deposits amount if found
    * Does nothing if not found
    * @param bk account to deposit to & deposit amount
    * @return true if deposited false if not
    */
   public boolean deposit(BankAccount bk)
   {
      if ( contains(bk) )
      {
         bankDB[find(bk)].credit(bk.getBalance());
         return true;
      }
      return false;
   }

   /**
    * Withdraws money from balance if found and enough money
    * Does nothing if not found or not enough money
    * @param bk bank account to withdraw from and amount
    * @return 0 if withdrawn -1 if not found 1 if not enough money
    */
   public int withdraw(BankAccount bk)
   {
      if ( contains(bk) )
      {
         if ( bankDB[find(bk)].debit(bk.getBalance()))     
            return 0;
         else 
            return 1;
      }
      return -1;
   }

   /**
    * Prints list of accounts Name and balance.
    */
   public void print()
   {
      for ( int i = 0; i < numAcct; i++ )
         System.out.println( bankDB[i].toString() );
   }

   /**
    * Checks if the given account is in the list
    * @param bk account to find
    * @return true if found and false if not. 
    */
   public boolean contains(BankAccount bk)
   {
      for ( int i = 0; i < numAcct; i++)
      {
         if ( bankDB[i].equals(bk) == true)
            return true;
      }
      return false;
   }
}  

