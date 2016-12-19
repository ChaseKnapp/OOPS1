
/**
 Runs through the input processing each expression. Depending on expression 
 pushes to operand stack or performs function. 
 @author knapp_000
 */
import java.io.*;
import java.util.*;
import java.util.StringTokenizer;
public class PostfixEvaluator 
{
   private static final int STACK_SIZE = 100;
   private Stack operandStack;
   private String expression;
   private ArrayList<Complex> answers;
   private int count = 0, total = 0;
   
   /**
   Reads expression. Checks token to determine if operand or else. 
   Performs correct process. 
   @param exp the string to be processed. 
   */
   private void processExpression( String exp)
   {
      total++;
      count++;
      System.out.print("Expression " + total + " is:");
      boolean valid = true; 
      StringTokenizer st = new StringTokenizer(exp, " " );
      while ( valid == true && st.hasMoreTokens())
      {
         String token = st.nextToken();
         if ( token.equals("+") || token.equals("-") || token.equals("*")
               || token.equals("~"))
            valid = processOperator(token);
         else 
            if ( processOperand(token) == false)
              valid = false;
         if ( valid == false)
         {
            falsePrint(token);
            return;
         }
         else 
            System.out.print(" " + token);
      }  
      endWhile();
   }
   
   /**
   adds the operand to stack if it is allowed number. Else returns false. 
   @param str token to be processed into the stack. 
   @return true if successful, false if not. 
   */
   private boolean processOperand( String str)
   {
      if ( str.equals("i"))
         operandStack.push(new Complex(0,1));
      else 
      {
         try 
         {
            operandStack.push( new Complex(Integer.parseInt(str)));
         }
         catch (NumberFormatException e)
         {
            return false;
         }
      }
      return true;
   }
   
   /**
   Checks if token is allowed operator. Processes if it is allowed returns 
   error if not. 
   @param str token to be processed.
   @return false if failed true if succeeded. 
   */
   private boolean processOperator( String str)
   {
      Complex obj1, obj2;
      if ( operandStack.isEmpty())
         return false;
      else
      {
         obj1 = operandStack.pop();
         if ( str.equals("~"))
            operandStack.push(obj1.conjugate());
         else
         {
            if ( operandStack.isEmpty())
               return false;
            else 
            {   
               obj2 = operandStack.pop();
               if ( str.equals("+"))
                  operandStack.push( obj1.plus(obj2));
               else if ( str.equals("-"))
                  operandStack.push(obj2.minus(obj1));
               else 
                  operandStack.push(obj2.times(obj1));
            }
         }
      }
      return true;
   }
   
   /**
   Prints the list of answers and prints, determines if real, imaginary, or 
   complex. 
   */
   private void printAnswers()
   {
      System.out.println("The list of good answers is:");
      for ( int i = 0; i < count; i++)
      {
         Complex t = answers.get(i);
         Complex s = t.conjugate().plus(t);
         if ( t.conjugate().equals(answers.get(i)))
            System.out.println(answers.get(i) + " is real");
         else 
            if ( s.equals(new Complex(0,0)))
               System.out.println(answers.get(i) + " is imaginary");
            else 
               System.out.println(answers.get(i) + " is complex");
      }
   }
   
   /**
   prints out error for bad expressions. 
   @param token token to be printed. 
   */
   private void falsePrint( String token)
   {
      System.out.println(" " + token);
      System.out.println("Invalid Expression!");
      count--;
   }
   
   /**
   outputs successes and errors depending on if success or error. 
   */
   private void endWhile()
   {
      if ( operandStack.isEmpty())
      {
         System.out.println();
         System.out.println("Invalid Expression!");
         count--;
      }
      else
      {
         Complex test = operandStack.pop();
         if ( operandStack.isEmpty())
         {
            operandStack.push(test);
            System.out.println();
            answers.add( count - 1, operandStack.pop());
            System.out.println("The value is: " + answers.get(count - 1));
         }
         else 
         {
            System.out.println();
            System.out.println("Invalid Expression!");
            count--;
         }
      }
   }
   
   /**
   runs through the inputs till eof
   @throws IOException 
   */
   public void run() throws IOException
   {
      BufferedReader stdin = new BufferedReader(new
         InputStreamReader(System.in));
      //BufferedReader stdin = new BufferedReader(new FileReader("P3.in"));
      operandStack = new Stack( STACK_SIZE ) ;
      answers = new ArrayList<Complex>();
      //boolean end = false;
      expression = stdin.readLine();
      while ( expression != null )
      {
         operandStack.clear();
         processExpression(expression);
         expression = stdin.readLine();
      }
      printAnswers();
      System.out.println("Normal Termination of Program 3.");
   }
}
