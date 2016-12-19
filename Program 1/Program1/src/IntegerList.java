/**
This class implements an unordered list. The list can store up to 8 integers.
@ author Chase Knapp  
*/
public class IntegerList 
{   
   //DO_1: 
   //declare (1)a constant identifier MAX_SIZE and assign 8 to it. 
   //        (2)an integer array variable  
   
   final int MAX_SIZE = 10;
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
   @param num
   */
   public void add(int num)
   {   
      if ( isFull() == true )
         System.out.println("The list is full!");
      else
      {   
         intNumbers[currentSize++] = num;
         System.out.println(Integer.toString(num) 
                   + " has been added to the list.");                  
      }   
   }
   /**
   This method removes given number from the list if in list.
   @param num to remove
   */
   public void remove(int num)
   {
      if ( isEmpty() == true)
      {
         System.out.println("Empty list!");
         return;
      }
      int pos = find(num);
      if ( pos == -1 )
      {
         System.out.println( num + " is not in the list." );
         //return ;
      }
      else 
      {
         for ( int i = pos; i < currentSize - 1; i++)
         {
            intNumbers[i] = intNumbers[i+1];
         }
         currentSize--;
         System.out.println(num + " has been removed from the list.");
      }
   }
   /**
   This method makes all odd numbers even then prints out list. 
   */
   public void makeEven()
   {
      if ( isEmpty() == true)
      {
         System.out.println("Empty list!");
         return;
      }
      int temp = 0;
      for ( int i = 0; i < currentSize; i++)
      {
         if ( intNumbers[i] % 2 != 0)
         {
            temp = intNumbers[i];
            intNumbers[i] = temp + 1;
         }
      }
      print();
   }
   /**
   This method prints out all values that are less than the average.
   */
   public void printLessThanAverage()
   {
      if ( isEmpty() == true)
      {
         System.out.println("Empty list!");
         return;
      }
      float avg = average();
      System.out.println ("Average: " + avg);
      System.out.print ( "Integers less than average:");
      for ( int i = 0; i < currentSize; i++)
      {
         if (intNumbers[i] < avg)
            System.out.print (" " + intNumbers[i]);
      }
      System.out.println(" ");
   }
   
   /**
   This method computes and returns the average of all integers in the list.
   @return average of the list
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
      if ( isEmpty() == true)
      {
         System.out.println("Empty list!");
         return;
      }         
      System.out.print("List of integers: ");
      for (int i = 0; i < currentSize; i++) 
      {
         //DO_3: output a single element followed by a space
         System.out.print( intNumbers[i] + " ");
      }
      System.out.println(" ");
   }
   /**
   This method finds the index of given number. 
   @param num number being found
   @return -1 if number is not found. index if it is.
   */
   private int find(int num)
   {
      for ( int i = 0; i < currentSize; i++)
      {
         if ( num == intNumbers[i] )
            return i;
      }
      return -1;
   }
   /**
   This method checks if the list is empty.
   @return true if empty false if not.
   */
   private boolean isEmpty()
   {
      if ( currentSize == 0 )
         return true;
      else
         return false;
   }
   /**
   This method checks if the list is full.
   @return true if full false if not. 
   */
   private boolean isFull()
   {
      if ( currentSize >= MAX_SIZE)
         return true;
      else 
         return false;
   }
   
}
