
/**
 Stack of Complex. has push, pop, and other methods.
 @author knapp_000
 */
public class Stack 
{
   private Complex[] elements;
   private int top;
   
   /**
   Constructor for stack. 
   @param size Gives the size the stack will be.
   */
   public Stack( int size)
   {
      elements = new Complex[size];
      top = 0;
   }
   
   /**
   Checks if the top is 0 for the stack. 
   @return true if top = 0, false if else
   */
   public boolean isEmpty()
   {
      return top == 0;
   }
   
   /**
   Pushes obj to the top of the stack. increments top
   @param obj a complex to add to stack.
   */
   public void push ( Complex obj)
   {
      elements[top++] = obj;
   }
   
   /**
   Returns the top element of stack. decrements top
   @return top Complex of stack
   */
   public Complex pop()
   {
      return elements[--top];
   }
   
   /**
   "Clears" the stack. sets top to 0
   */
   public void clear()
   {
      top = 0;
   }
}
