
/**
 * Subclass of student for students from out of state. Contains information
 * for outstate students. 
 * @author Chase Knapp
 */
public class Outstate extends Student
{
    private final int LOW_CREDIT = 12;
    private final int HIGH_CREDIT = 15;
    private final int PART_TIME = 846;
    private final int FULL_TIME= 1441;
    private final int CREDIT_COST = 756;
    private final int DISCOUNT = 200;
    int discount = 0;
    
    /**
    Constructor for Outstate student
    @param id student id
    @param name student name
    @param credit credit hours taken
    @param tristate state of residence flag
    */
    public Outstate(String id, String name, int credit, boolean tristate)
    {
        super(id,name,credit);
        if (tristate) 
        {
            discount = DISCOUNT;
        }
                
    }
    
    /**
     * Computes tuition based on credit hours and  state discount
     * @return tuition 
     */
    public int tuitionDue()
    {
        int tuition = 0;
        if ( credit <  LOW_CREDIT )
            tuition = credit * ( CREDIT_COST - discount ) + PART_TIME;
        else
        {
            if ( credit >= HIGH_CREDIT)
                tuition = HIGH_CREDIT * ( CREDIT_COST - discount ) + FULL_TIME;
            else 
                tuition = credit * ( CREDIT_COST - discount ) + FULL_TIME;
        }
                
        return tuition;
    }
    /**
     * returns string of student information. used in report
     * @return String
     */
    public String toString()
    {
        return ("Student name: " + name + " Student ID: " + id + " owes $" 
                                 + tuitionDue() + ".");   
    }
}
