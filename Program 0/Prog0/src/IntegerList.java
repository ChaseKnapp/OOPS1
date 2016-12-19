/**
This class implements an unordered list. The list can store up to 8 integers.
@Chase Knapp  
*/
public class IntegerList 
{   
   //DO_1: 
   //declare (1)a constant identifier MAX_SIZE and assign 8 to it. 
   //        (2)an integer array variable  
   
   final int MAX_SIZE = 8;
   int [] intNumbers;
   int currentSize; //store the number of integers currently in the list
   /*
   This is a default constructor that creates an empty list and intializes
   current size of the list to 0.
   */
   public IntegerList()
   {
      intNumbers = new int[MAX_SIZE];
      currentSize = 0;   
   }   
   /*
   Given an integer, this method adds the integer to the list and displays  
   a message indicating the integer has been added. If the list is full, 
   display an error message.
   */
   public void add(int num)
   {   
      if ( currentSize >= MAX_SIZE )
         System.out.println("The list is full!");
      else
      {   
         intNumbers[currentSize++] = num;
         System.out.println("Integer " + Integer.toString(num) 
                   + " has been added to the list");                  
      }   
   }
   /**
   This method computes and returns the average of all integers in the list.
   @return 
   */
   public float average()
   {
      //DO_2: Loop thru the list, compute and return the average
      //      The average is a float.
      float average = 0;
      for (int i = 0; i < currentSize; i++)
      {
          average += intNumbers[i];  
      }
      average = ( average / currentSize );
      return average;
      
   }     
   /**
   This method displays all integers in the list.
   */
   public void print()
   {
      System.out.print("List of integers: ");
      for (int i = 0; i < currentSize; i++) 
      {
         //DO_3: output a single element followed by a space
         System.out.print( intNumbers[i] + " ");
      }
      System.out.println(" ");
   }
}
