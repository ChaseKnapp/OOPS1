/**
ListManipulator class performs the operations on the list, including add, 
quit, print and average. 
@author Chase Knapp 
*/

//DO_4: import Scanner class  
import java.util.Scanner;
public class ListManipulator 
{
   public void run()
   {
      //DO_5: Instantiate an object 'stdin' with Scanner class, new the 
      //      object by call the constructor Scanner(System.in) with 
	  //      standard input System.in.
	   Scanner stdin = new Scanner(System.in);
      IntegerList intList = new IntegerList();
      String command = new String(); 
      command = stdin.next(); //priming read
      while ( !command.equals("Q") )
      {   
	     //DO_6: call equals method and compare if the command is "A"
         if ( command.equals("A") || command.equals ("a") )
         {  
            while ( stdin.hasNextInt() )        
               intList.add(stdin.nextInt());  
         } //Add command 
         else if ( command.equals ("D") || command.equals ("d") )
         {
            intList.remove(stdin.nextInt());
         }
         else if ( command.equals ("E") || command.equals ("e") )
         {
            intList.makeEven();
         }
         else if ( command.equals ("P") || command.equals ("p") )
         {
            intList.print();
         }
         else if ( command.equals ("V") || command.equals ("v") )
         {
            intList.printLessThanAverage();
         }
         else 
         {
            System.out.println ( "Command '" + command + "' not supported.");
         }
         command = stdin.next(); //read next token
      }   
      System.out.println ( "Good Bye!");
   } //run
} //ListManipulator
