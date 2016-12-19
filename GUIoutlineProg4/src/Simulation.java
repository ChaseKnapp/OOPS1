public class Simulation
{
   private static final int MAX_AIRCRAFT = 5;
   private static final int TAKE_OFF_TIME = 3;
   private static final int DEPARTURE_TIME = 2;
   private Queue<Aircraft> q = new Queue<>(MAX_AIRCRAFT);
   private int currentTime;
   private Aircraft currentAircraft = null;
   private Aircraft departedCraft;
   private int tookOff;
   private int noWait;
   private int acWaited;
   private int tWaitTime;
  
   /**
   Constructor for Simulation class. Sets all variable values to zero. 
   */
   public Simulation()
   {
      currentTime = 0;
      tookOff = 0;
      noWait = 0;
      acWaited = 0;
      tWaitTime = 0;
   }
   
   /**
   This method contains the take off command for an aircraft. The aircraft
   held in currentAircraft takes off. The next aircraft in the queue will then
   move into the spot. If there are no aircraft in the queue, the
   currentAircraft will contain nothing (null). If there was no aircraft in
   currentAircraft, false is returned. True is returned upon a successful take
   off. A successful take off lasts 3 time units.
   @return false if there is no aircraft ready to take off. Otherwise, true.
   */
   public boolean takeOff()
   {
      if(currentAircraft == null)
         return false;
      else
      {
         departedCraft = currentAircraft;
         if(q.isEmpty())
            currentAircraft = null;
         else
         {
            currentAircraft = (Aircraft) q.dequeue();
            tWaitTime += (currentTime - currentAircraft.getTimestamp());
            acWaited++;
         }
      }
      currentTime += TAKE_OFF_TIME;
      tookOff++;
      return true;
   }
   
   
   /**
   This method advances the simulation timer by 'time' units.
   @param time
   */
   public void noAction(int time)
   {
      currentTime += time;
   }
   
   /**
   This method returns the number of aircraft that have departed.
   @return the number of aircraft that have departed
   */
   public int getTookOff()
   {
      return tookOff;
   }
   
   /**
   This method returns the number of aircraft that have waited and departed.
   @return the number of aircraft that have wait and departed
   */
   public int getNoWait()
   {
      return noWait;
   }
   
   /**
   This method returns the number of aircraft that had to wait in the queue
   before departing.
   @return the number of aircraft that had to wait
   */
   public int getAcWaited()
   {
      return acWaited;
   }
   /**
   This method gets the string from the most recently departed aircraft and 
   passes it.
   @return The output of departedCraft.toString() is returned.
   */
   public String getAircraftString()
   {
      return departedCraft.toString();
   }
   /**
   This method gets the string from the next aircraft to depart and 
   passes it.
   @return The output of currentCraft.toString() is returned.
   */ 
   public String getNextAircraftString()
   {
      return currentAircraft.toString();
   }
   /**
   Checks if there is an aircraft in current aircraft
   @return true if not null false if null
   */
   public boolean getCurrentAircraft()
   {
      if ( currentAircraft == null )
         return false;
      else 
         return true;
   }
   /**
   This method returns the total time that departed aircraft had waited in the
   queue.
   @return the total time that departed aircraft waited
   */
   public int getTWaitTime()
   {
      return tWaitTime;
   }
   
   /**
   Adds an aircraft to the queue if the queue is not full. If there is no 
   aircraft in currentAircraft it gets placed there. 
   @return true if aircraft is added, false if queue if full. 
   */
   public boolean departure()
   {
      if ( q.isFull())
         return false;
      else
      {
         currentTime += DEPARTURE_TIME;
         if ( currentAircraft != null)
         {
            q.enqueue( new Aircraft(currentTime));
            //acWaited++;
         }
         else 
         {
            currentAircraft = new Aircraft(currentTime);
            noWait++;
         }
         return true;
      }
   }
   /**
   This method returns the current size of the Queue.
   @return The size of the queue is returned.
   */
   public int returnQueueSize()
   {
      return q.size();
   }
   
   /**
   This method clears the queue. It will only be used by the testbed main().
   */
   public void clearQueue()
   {
      q.clear();
   }
   
   /**
   This method returns the current time.
   @return the number of aircraft that had to wait
   */
   public int getCurrentTime()
   {
      return currentTime;
   }
   
   /**
   This method tests the Simulation class.
   @param Args 
   */
   public static void main ( String Args[] )
   {
      Simulation n = new Simulation();
      // Test 0: Tests getCurrentTime()
      System.out.println("Test 0");
      System.out.println("The current time is " + n.getCurrentTime());
      
      // Test 1: Test the noAction() method
      System.out.println("Test 1");
      System.out.println("The current time is " + n.currentTime);
      n.noAction(TAKE_OFF_TIME);
      System.out.println("The current time is " + n.currentTime);
      
      // Test 2: Test takeOff() method when there us no aircraft
      // in currentAircraft
      System.out.println("Test 2");
      n.clearQueue();
      n.currentAircraft = null;
      if(n.takeOff())
         System.out.println("Aircraft Took Off. Time is " + n.currentTime);
      else
         System.out.println("ERROR: NO AIRCRAFT READY");
      
      // Test 3: Test takeOff() with an empty queue and an aircraft in
      // currentAircraft
      System.out.println("Test 3");
      n.clearQueue();
      n.currentAircraft = null;
      if(n.departure())
         System.out.println("Aircraft Departed. Time is " + n.currentTime);
      else
         System.out.println("ERROR: QUEUE IS FULL");
      if(n.takeOff())
         System.out.println("Aircraft Took Off. Time is " + n.currentTime);
      else
         System.out.println("ERROR: NO AIRCRAFT READY");
      if(n.takeOff())
         System.out.println("Aircraft Took Off. Time is " + n.currentTime);
      else
         System.out.println("ERROR: NO AIRCRAFT READY");
      
      // Test 4: Test takeOff() with an aircraft in the queue and an aircraft
      // in currentAircraft
      System.out.println("Test 4");
      n.clearQueue();
      n.currentAircraft = null;
      if(n.departure())
         System.out.println("Aircraft Departed. Time is " + n.currentTime);
      else
         System.out.println("ERROR: QUEUE IS FULL");
      if(n.departure())
         System.out.println("Aircraft Departed. Time is " + n.currentTime);
      else
         System.out.println("ERROR: QUEUE IS FULL");
      if(n.takeOff())
         System.out.println("Aircraft Took Off. Time is " + n.currentTime);
      else
         System.out.println("ERROR: NO AIRCRAFT READY");
      if(n.takeOff())
         System.out.println("Aircraft Took Off. Time is " + n.currentTime);
      else
         System.out.println("ERROR: NO AIRCRAFT READY");
      
      // Test 5: Test getTookOff() method when no aircraft have taken off.
      System.out.println("Test 5");
      n.clearQueue();
      n.currentAircraft = null;
      n.tookOff = 0;
      System.out.println("Aircraft that took off: " + n.getTookOff());
      
      // Test 6: Test getTookOff() method when aircraft have taken off.
      System.out.println("Test 6");
      n.clearQueue();
      n.currentAircraft = null;
      n.tookOff = 0;
      if(n.departure())
         System.out.println("Aircraft Departed. Time is " + n.currentTime);
      else
         System.out.println("ERROR: QUEUE IS FULL");
      if(n.departure())
         System.out.println("Aircraft Departed. Time is " + n.currentTime);
      else
         System.out.println("ERROR: QUEUE IS FULL");
      if(n.takeOff())
         System.out.println("Aircraft Took Off. Time is " + n.currentTime);
      else
         System.out.println("ERROR: NO AIRCRAFT READY");
      if(n.takeOff())
         System.out.println("Aircraft Took Off. Time is " + n.currentTime);
      else
         System.out.println("ERROR: NO AIRCRAFT READY");
      System.out.println("Aircraft that took off: " + n.getTookOff());
      
      // Test 7 test GetAcWaited when aircraft no have waited
      System.out.println("Test 7");
      n.clearQueue();
      n.currentAircraft = null;
      n.acWaited = 0;
      if (n.departure())
         System.out.println("Aircraft Departed. Time is " + n.currentTime);
      else 
         System.out.println("ERROR");
      if (n.takeOff())
         System.out.println("Aircraft Took Off. Time " + n.currentTime);
      else 
         System.out.println("ERROR");
      System.out.println("Aircraf that waited to take off: " 
            + n.getAcWaited());
      
      // Test 8 test GetAcWaited when aircraft have waited
      System.out.println("Test 8");
      n.clearQueue();
      n.currentAircraft = null;
      n.acWaited = 0;
      if (n.departure())
         System.out.println("Aircraft Departed. Time is " + n.currentTime);
      else 
         System.out.println("ERROR");
      if (n.departure())
         System.out.println("Aircraft Departed. Time is " + n.currentTime);
      else 
         System.out.println("ERROR");
      if (n.takeOff())
         System.out.println("Aircraft Took Off. Time " + n.currentTime);
      else 
         System.out.println("ERROR");
      if (n.takeOff())
         System.out.println("Aircraft Took Off. Time " + n.currentTime);
      else 
         System.out.println("ERROR");
      System.out.println("Aircraf that waited to take off: " 
            + n.getAcWaited());
      
      // Test 9 test GetWaitTime with no wait
      System.out.println("Test 9");
      n.clearQueue();
      n.currentAircraft = null;
      n.tWaitTime = 0;
      if (n.departure())
         System.out.println("Aircraft Departed. Time is " + n.currentTime);
      else 
         System.out.println("ERROR");
      if (n.takeOff())
         System.out.println("Aircraft Took Off. Time " + n.currentTime);
      else 
         System.out.println("ERROR");
      System.out.println("Total time waited: " + n.getTWaitTime());
      
      // Test 10 test GetWaitTime with 1 aircraft 
      System.out.println("Test 10");
      n.clearQueue();
      n.currentAircraft = null;
      n.tWaitTime = 0;
      if (n.departure())
         System.out.println("Aircraft Departed. Time is " + n.currentTime);
      else 
         System.out.println("ERROR");
      if(n.departure())
         System.out.println("Aircraft Departed. Time is " + n.currentTime);
      else 
         System.out.println("ERROR");
      if (n.takeOff())
         System.out.println("Aircraft Took Off. Time " + n.currentTime);
      else 
         System.out.println("ERROR");
      if (n.takeOff())
         System.out.println("Aircraft Took Off. Time " + n.currentTime);
      else 
         System.out.println("ERROR");
      System.out.println("Total time waited: " + n.getTWaitTime());
      
      // Test 11 test GetWaitTime with multiple aircraft 
      System.out.println("Test 11");
      n.clearQueue();
      n.currentAircraft = null;
      n.tWaitTime = 0;
      if(n.departure())
         System.out.println("Aircraft Departed. Time is " + n.currentTime);
      else 
         System.out.println("ERROR");
      if(n.departure())
         System.out.println("Aircraft Departed. Time is " + n.currentTime);
      else 
         System.out.println("ERROR");
      if(n.departure())
         System.out.println("Aircraft Departed. Time is " + n.currentTime);
      else 
         System.out.println("ERROR");
      if (n.takeOff())
         System.out.println("Aircraft Took Off. Time " + n.currentTime);
      else 
         System.out.println("ERROR");
      if (n.takeOff())
         System.out.println("Aircraft Took Off. Time " + n.currentTime);
      else 
         System.out.println("ERROR");
      if (n.takeOff())
         System.out.println("Aircraft Took Off. Time " + n.currentTime);
      else 
         System.out.println("ERROR");
      System.out.println("Total time waited: " + n.getTWaitTime());
      
      // Test 12 test getAircraftString() method
      System.out.println("Test 12");
      n.clearQueue();
      n.currentAircraft = null;
      if(n.departure())
         System.out.println("Aircraft Departed. Time is " + n.currentTime);
      else
         System.out.println("ERROR: QUEUE IS FULL");
      if(n.takeOff())
         System.out.println("Aircraft Took Off. Time is " + n.currentTime);
      else
         System.out.println("ERROR: NO AIRCRAFT READY");
      System.out.println(n.getAircraftString());
      
      // Test 13 Add 2 aircraft to empty queue
      System.out.println("Test 13");
      n.clearQueue();
      n.currentAircraft = null;
      if (n.departure())
         System.out.println("Sucess. Current time is " + n.currentTime);
      else 
         System.out.println("ERROR");
      if (n.departure())
         System.out.println("Sucess. Current time is " + n.currentTime);
      else 
         System.out.println("ERROR");
      
      // Test 14 Add aircraft to full queue 
      System.out.println("Test 14");
      n.currentAircraft = null;
      n.clearQueue();
      if (n.departure())
         System.out.println("Sucess. Current time is " + n.currentTime);
      else 
         System.out.println("ERROR");
      if (n.departure())
         System.out.println("Sucess. Current time is " + n.currentTime);
      else 
         System.out.println("ERROR");
      if (n.departure())
         System.out.println("Sucess. Current time is " + n.currentTime);
      else 
         System.out.println("ERROR");
      if (n.departure())
         System.out.println("Sucess. Current time is " + n.currentTime);
      else 
         System.out.println("ERROR");
      if (n.departure())
         System.out.println("Sucess. Current time is " + n.currentTime);
      else 
         System.out.println("ERROR");
      if (n.departure())
         System.out.println("Sucess. Current time is " + n.currentTime);
      else 
         System.out.println("ERROR");
      if (n.departure())
         System.out.println("Sucess. Current time is " + n.currentTime);
      else 
         System.out.println("ERROR. Current time is " + n.currentTime);
      
      //Test 15 Return Queue Size
      System.out.println("Test 15");
      n.currentAircraft = null;
      n.clearQueue();
      if (n.departure())
         System.out.println("Sucess. Current time is " + n.currentTime);
      else 
         System.out.println("ERROR");
      if (n.departure())
         System.out.println("Sucess. Current time is " + n.currentTime);
      else 
         System.out.println("ERROR");
      if (n.departure())
         System.out.println("Sucess. Current time is " + n.currentTime);
      else 
         System.out.println("ERROR");
      System.out.println("Queue size is " + n.returnQueueSize());
   }    
}