
/**
 Queue class with queue methods.
 @author knapp_000
 */
public class Queue<E> 
{
   private E [] elements;
   private int front, rear, count;
   
   /**
   Queue constructor. 
   @param size size of queue
   */
   public Queue (int size)
   {
      elements = (E[])new Object[size];
      front = rear = count = 0;
   }
   
   /**
   Checks if the queue is empty. count equals zero.
   @return true if empty false if not
   */
   public boolean isEmpty()
   {
       return count == 0;
   }
   
   /**
   Checks if the queue is full. count equals size
   @return true if full false if not.
   */
   public boolean isFull()
   {
       return count == elements.length;
   }
   
   /**
   Adds an aircraft to the queue
   @param x aircraft to add
   */
   public void enqueue ( E x )
   {
       elements[rear] = x;
       rear = (rear + 1) % elements.length;
       count++;
   }
   
   public Object dequeue ()
   {
       Object x = elements[front];
       front = ( front + 1 ) % elements.length;
       count--;
       return x;
   }
   
   public int size()
   {
       return count;
   }
   
   public void clear()
   {
      count = 0;
      front = 0;
      rear = 0;
   }
}
