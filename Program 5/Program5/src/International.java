/**
This class contains the information needed regarding an International Student.
@author Adam
*/
public class International extends Student
{
   private final int FULL_TIME_CREDIT = 12;
   private final int FULL_TIME_FEE = 1441;
   private final int PART_TIME_FEE = 846;
   private final int CREDIT_FEE = 945;
   private final int INTERNATIONAL_FEE = 350;
   private final int MAX_CREDITS = 15;
   private final boolean exchange;
   
   /**
   This is the main constructor for this class. It reads in student
   information. The information is validated at higher level.
   @param id Student's id
   @param name Student's name
   @param credit Number of credits the student is taking
   @param ex The flag signifies if the student is an exchange student
   */
   public International(String id, String name, int credit, boolean ex)
   {
      super(id, name, credit);
      exchange = ex;
   }
   
   /**
   This class calculates the tuition due by an International student.
   @return The amount of tuition due is returned
   */
   public int tuitionDue()
   {
      int tuition = INTERNATIONAL_FEE;
      if(credit < FULL_TIME_CREDIT)
      {
         tuition += PART_TIME_FEE;
      }
      else
      {
         tuition += FULL_TIME_FEE;
      }
      if(!exchange)
      {
         if(credit > MAX_CREDITS)
         {
            tuition += MAX_CREDITS * CREDIT_FEE;
         }
         else
         {
            tuition += credit * CREDIT_FEE;
         }
      }
      return tuition;
   }
   
   /**
   This method returns a string about the student that will be used to 
   generate a report.
   @return A string with all relevant information is returned.
   */
   public String toString()
   {
      return ("Student name: " + name + " Student ID: " + id + " owes $" 
                                 + tuitionDue() + ".");   
   }
}