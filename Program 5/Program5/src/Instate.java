/**
This class contains the information needed regarding an In State Student.
@author Adam
*/
public class Instate extends Student
{
   private final int FULL_TIME_CREDIT = 12;
   private final int FULL_TIME_FEE = 1441;
   private final int PART_TIME_FEE = 846;
   private final int CREDIT_FEE = 433;
   private final int MAX_CREDITS = 15;
   private final int scholarship;
   
   /**
   This is the main constructor for this class. It reads in student
   information. The information is validated at higher level.
   @param id Student's id
   @param name Student's name
   @param credit Number of credits the student is taking
   @param moneyAwards The amount of scholarship money the student has received
   */
   public Instate(String id, String name, int credit, int moneyAwards)
   {
      super(id, name, credit);
      scholarship = moneyAwards;
   }
   
   /**
   This class calculates the tuition due by an Instate student.
   @return The amount of tuition due is returned
   */
   public int tuitionDue()
   {
      int tuition;
      if(credit > MAX_CREDITS)
      {  
         tuition = CREDIT_FEE * MAX_CREDITS - scholarship;
      }
      else if(credit >= FULL_TIME_CREDIT)
      {
         tuition = CREDIT_FEE * credit - scholarship;
      }
      else
      {
         tuition = CREDIT_FEE * credit;
      }
      if(credit < FULL_TIME_CREDIT)
      {
         tuition += PART_TIME_FEE;
      }
      else
      {
         tuition += FULL_TIME_FEE;
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
