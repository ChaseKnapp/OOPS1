
/**
 This class is the abstract student class. 
 @author knapp_000
 */
public abstract class Student implements Comparable 
{
   protected String id;
   protected String name;
   protected int credit;
   
   /**
    * Constructor for student 
    * @param id string of student id
    * @param name string of student name
    * @param credit int of student credits
    */
   public Student(String id, String name, int credit)
   {
   this.id = id;
   this.name = name;
   this.credit = credit;
   }
   /**
    * compute the tuition due; subclasses must override this method
    * @return 
    */
   public int tuitionDue()
   {
        return 0;
   }
   /**
    * compare two student objects if they have the same id and name
    * @param obj student to compare
    * @return 
    */
   public int compareTo(Object obj)
   {
        if ( obj instanceof Student)
        {  
            Student x = (Student)obj;
            if ( id.equals(x.id) && name.equals(x.name) )
            return 0;
        }
        return -1;
   }
   //return a string with detailed student information
   //id, name, credit hours, student type, scholarship, discount, or exchanged
   public abstract String toString();
}
