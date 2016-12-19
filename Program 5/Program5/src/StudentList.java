/**
This is the StudentList class. It contains the list of students and the
appropriate methods to add or remove students from the list. There are also
methods to help calculate tuition for a single student or all the students.

@author Adam
*/
public class StudentList
{
   private final int GROW_SIZE = 4;
   private Student [] list;
   private int listSize;
   
   /**
   This is the main constructor of the StudentList Class. The list is
   initialized to the length of the grow size (4).
   */
   public StudentList()
   {
      list = new Student [GROW_SIZE];
      listSize = 0;
   }
   
   /**
   This method is called when the list is full. The list size is extended by 4
   */
   private void grow()
   {
      Student [] temp = new Student [ list.length + GROW_SIZE];
      for( int i = 0;  i < listSize; i++ )
         temp[i] = list[i];
      list = temp;
   }
   
   /**
   This method adds an Instate Student to the list. First the input
   information is checked to make sure it is valid. If the information is
   invalid, -1 is returned. If the information is valid, the method will check
   to see if the student is in the list already. If the student is in the
   list, 0 is returned. If the student is not in the list, the student is 
   added and 1 is returned.
   @param id The student's id. It cannot be blank
   @param name The student's name. It cannot be blank
   @param credit The number of credits the student is taking. It must be
                                                               greater than 0
   @param scholarship The amount of scholarship money the student has received
   @return -1 is returned if input information is invalid. 0 is returned if
   the student exists already. 1 is returned if the student is added.
   */
   public int addInstate(String id, String name, int credit, 
                                                         int scholarship)
   {
      int index = -1;
      Instate temp;
      if((scholarship < 0)||(credit <= 0)||(id.equals(""))||(name.equals("")))
         return -1;
      else
      {
         temp = new Instate(id,name,credit,scholarship);
         for( int i = 0; i < listSize; i++ )
            if(temp.compareTo(list[i])==0)
               index = i;
         if(index != -1)
            return 0;
         if(listSize == list.length)
            grow();
         list[listSize++] = temp;
         return 1;
      }
   }
   
   /**
   This method adds an OutState Student to the list. First the input
   information is checked to make sure it is valid. If the information is
   invalid, -1 is returned. If the information is valid, the method will check
   to see if the student is in the list already. If the student is in the
   list, 0 is returned. If the student is not in the list, the student is 
   added and 1 is returned.
   @param id The student's id. It cannot be blank
   @param name The student's name. It cannot be blank
   @param credit The number of credits the student is taking. It must be
                                                               greater than 0
   @param tristate This flag signifies if the student receives the tristate
                                                               discount
   @return -1 is returned if input information is invalid. 0 is returned if
   the student exists already. 1 is returned if the student is added.
   */
   public int addOutstate(String id, String name, int credit, 
                                                         boolean tristate)
   {
      int index = -1;
      Outstate temp;
      if((credit <= 0)||(id.equals(""))||(name.equals("")))
         return -1;
      else
      {
         temp = new Outstate(id,name,credit,tristate);
         for( int i = 0; i < listSize; i++ )
            if(temp.compareTo(list[i])==0)
               index = i;
         if(index != -1)
            return 0;
         if(listSize == list.length)
            grow();
         list[listSize++] = temp;
         return 1;
      }
   }
   
   /**
   This method adds an International Student to the list. First the input
   information is checked to make sure it is valid. If the information is
   invalid, -1 is returned. If the information is valid, the method will check
   to see if the student is in the list already. If the student is in the
   list, 0 is returned. If the student is not in the list, the student is 
   added and 1 is returned.
   @param id The student's id. It cannot be blank
   @param name The student's name. It cannot be blank
   @param credit The number of credits the student is taking. It must be
                                                               greater than 0
   @param exchange This flag signifies if the student receives the exchange
                                                          student discount
   @return -1 is returned if input information is invalid. 0 is returned if
   the student exists already. 1 is returned if the student is added.
   */
   public int addInternational(String id, String name, int credit, 
                                                         boolean exchange)
   {
      int index = -1;
      International temp;
      if((credit <= 0)||(id.equals(""))||(name.equals("")))
         return -1;
      else
      {
         temp = new International(id,name,credit,exchange);
         for( int i = 0; i < listSize; i++ )
            if(temp.compareTo(list[i])==0)
               index = i;
         if(index != -1)
            return 0;
         if(listSize == list.length)
            grow();
         list[listSize++] = temp;
         return 1;
      }
   }
   
   /**
   This method attempts to remove a student from the list. If the student
   is not in the list, false is returned. If the student is removed from the
   list, true is returned.
   @param id The id of the student that is to be removed from the list
   @param name The name of the student that is to be removed from the list
   @return True if the student is removed. Otherwise, false
   */
   public boolean remove(String id,String name)
   {
      Instate temp = new Instate(id, name, 1, 0);
      int index = -1;
      for( int i = 0; i < listSize; i++ )
         if(temp.compareTo(list[i])==0)
            index = i;
      if(index == -1)
         return false;
      else
      {
         list[index] = list[--listSize];
         return true;
      }
   }
   
   /**
   This method returns the current size of the list.
   @return listSize is returned
   */
   public int returnListSize()
   {
      return listSize;
   }
   
   /**
   This method returns the tuition owed by a single student. If the student
   is not in the list, -1 is returned. Otherwise, the tuition due is returned.
   @param id The id of the student 
   @param name The name of the student
   @return -1 is returned if the student is not in the list.  Otherwise, the 
   tuition due is returned.
   */
   public int calculateTuition(String id, String name)
   {
      int index = -1;
      Student temp = new Instate(id, name, 1, 0);
      for( int i = 0; i < listSize; i++ )
         if(temp.compareTo(list[i])==0)
            index = i;
      if( index == -1 )
         return -1;
      else
         temp = list[index];
      return temp.tuitionDue();
   }
   
   /**
   This method returns the string for a student object given its position in 
   the list. This method is intended to be used in a loop that would print out 
   the report for all of the students.
   @param index The index pointing at the object in the list whose information
               will be returned.
   @return The string for the object is returned.
   */
   public String calculateReport(int index)
   {
      return list[index].toString();
   }
}
