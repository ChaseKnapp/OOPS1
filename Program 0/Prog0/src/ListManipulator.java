/**
ListManipulator class performs the operations on the list, including add, 
quit, print and average. 
@Chase Knapp 
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
      while ( !command.equals("Q"))
      {   
	     //DO_6: call equals method and compare if the command is "A"
         if ( command.equals("A") )
         {  
            while ( stdin.hasNextInt() )        
               intList.add(stdin.nextInt());  
         } //Add command     
         command = stdin.next(); //read next token
      }   
      intList.print();  
      System.out.println("Average of all integers in the list: " 
            + intList.average());
   } //run
} //ListManipulator
