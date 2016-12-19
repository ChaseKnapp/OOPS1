/**
Runs the main for Program 3
@author  
*/
public class Prog3
{
   /**
   Runs an instance of PostfixEvaluator.
   @param args is unused
   */
   public static void main (String args[])
   {
      try
      {
         new PostfixEvaluator().run();
      }
      catch (Exception e)
      {
         System.out.println("Program Error!!!: " + e );
      }      
   }
}
