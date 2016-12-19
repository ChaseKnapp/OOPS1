/**
Runs the main for Program 3
@author Chase Knapp 
*/
public class Prog4
{
   /**
   Runs an instance of PostfixEvaluator.
   @param args is unused
   */
   public static void main (String args[])
   {
      try
      {
         new ConsoleSimulator().run();
      }
      catch (Exception e)
      {
         System.out.println("Program Error!!!: " + e );
      }      
   }
}