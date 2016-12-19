
import java.util.Scanner;

/**
Class for performing the inputed functions.
Depending on what is entered a task is performed and an output is written. 
@author Chase Knapp
@author knapp_000
*/
public class ATM 
{
   private Scanner stdin;
   private BankDatabase bankDB;  
   private BankAccount acct;
   
   /**
   The run for the program. Gets input and determines what to do. 
   */
   public void run()
   {
      stdin = new Scanner(System.in);      
      bankDB = new BankDatabase();
      boolean done = false;  
      while ( !done )
      {
         String transaction = stdin.next();
         switch ( transaction.charAt(0))
         {   
            case 'D': deposit();
                      break;
            case 'W': withdraw();    
                      break;
            case 'O': open();
                      break;
            case 'C': close();
                      break;
            case 'B': balance();
                      break;
            case 'Q': done = true;    
                      break;
            default: System.out.println( "Command '" + transaction + "' not "
                  + "supported!");
         }  
      } 
      System.out.println( " "); 
	   System.out.println( "Bank Database...");
      bankDB.print();
      System.out.println( "ATM stop running.");
	   
   } 
   
   /**
   Adds money to bank accounts balance
   If bank account is in the list it adds given amount to the balance
   otherwise an error is given
   */
   private void deposit()
   {
      String acctStr = stdin.next();
      acct = new BankAccount(acctStr);
      if ( bankDB.deposit(acct) )
         System.out.println("New balance: "                
               + bankDB.balance(acct));
      else
         System.out.println("Account information incorrect!" );        
   }
   
   /**
   Withdraws money from bank account.
   If the account is found and there is enough money the amount given is 
   removed from the balance. Else an error is given. 
   */
   private void withdraw()
   {
      String acctStr = stdin.next();
      acct = new BankAccount(acctStr);
      int result = bankDB.withdraw(acct);
      if ( result == 1)
      {
         System.out.println( "Balance low! Current balance: " +
               bankDB.balance(acct) );
      }         
      else if ( result == -1)  
      {
         System.out.println( "Account Information incorrect!" );
      }    
      else
      {
         System.out.println( "New balance: " + bankDB.balance(acct) );
      }
          
   }
   
   /**
   Adds an account to the list
   If the account isn't already in the database it is added. Else is displays
   an error.
   */
   private void open()
   {
      String acctStr = stdin.next();
      acct = new BankAccount(acctStr);
      boolean result = bankDB.open(acct);
      if ( result == false)
      {
         System.out.println( "Duplicate account! Account opening failed." );
      }
      else 
      {
         System.out.println( "Account opening successful." );
      }
   }
   
   /**
   Removes and account from the list.
   If the account is found in the list it is removed. If it is not found an 
   error is printed. 
   */
   private void close()
   {
      acct = new BankAccount(stdin.next(), stdin.next());
      boolean result = bankDB.close(acct);
      if ( result == false)
      {
         System.out.println( "Account closing failed." );
      }
      else
      {
         System.out.println( "Account closing successful." );
      }
   }
   
   /**
   Prints balance of given account.
   If account is found the balance is printed. If it is not found an error is
   printed. 
   */
   private void balance()
   {
      String name = stdin.next();
      String account = stdin.next();
      acct = new BankAccount(name, account);
      int result = bankDB.balance(acct);
      if ( result == 0 )
      {
         System.out.println( "Account information incorrect!" );
      }
      else 
      {
         System.out.println( name + ", your current balance is "
               + bankDB.balance(acct));
      }  
   }  
} //end ATM class
