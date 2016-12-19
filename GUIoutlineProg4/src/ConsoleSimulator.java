/**
This class contains the console simulator. The run method will read in the
command from the console window and execute the commands from the simulation
class.

@author Adam Tomassetti
*/

import java.io.*;
import java.util.StringTokenizer;
public class ConsoleSimulator
{
   private String expression;
   private Simulation sim;
   
   /**
   This is the main method to run Program 4. In this method, the simulation 
   class is instantiated. This method also contains the commands to read in 
   the data strings and decides how to react to them. If 
   there is bad data being read in, it is thrown in this method.
   
   @throws IOException
   */
   public void run() throws IOException
   {
      sim = new Simulation();
      BufferedReader stdin = 
                      new BufferedReader(new InputStreamReader(System.in));
      //BufferedReader stdin = new BufferedReader(new FileReader("P4.in"));
      boolean done = false;
      while(!done)
      {
         expression = stdin.readLine();
         StringTokenizer tokenized = new StringTokenizer(expression, " ");
         String token = tokenized.nextToken();
         switch(token)
         {
            case "D": departure();
                      break;
            case "T": takeOff();
                      break;
            case "U": token = tokenized.nextToken();
                      skipTime(Integer.parseInt(token));
                      break;
            case "P": System.out.println();
                      stats();
                      break;
            case "Q": endProgram();
                      done = true;
                      break;
            default: System.out.println(token + " is invalid!");
                     break;
         }
      }
   }
   
   /**
   This method executes the take off command. The method also displays the 
   appropriate method on the console window.
   */
   public void takeOff()
   {
      if(sim.takeOff())
         System.out.println(sim.getAircraftString() + " took off @time "
                            + sim.getCurrentTime() + ". Number of aircraft "
                            + "waiting is " + sim.returnQueueSize() + ".");
      else
         System.out.println("No aircraft is taking off @time " 
                            + sim.getCurrentTime() + ".");
   }
   
   /**
   This method executes the departure command. The method also displays the 
   appropriate method on the console window.
   */
   public void departure()
   {
      if(sim.departure())
         System.out.println("An aircraft entered the runway @time "
                            + sim.getCurrentTime() + ". Number waiting "
                            +  "in queue is " + sim.returnQueueSize());
      else
         System.out.println("Aircraft had to wait at the gate because the"
                            + " line was full at time " 
                            + sim.getCurrentTime() + ".");
   }
   
   /**
   This method executes the update command. The system clock is incremented by
   'time'. The method also displays the appropriate method on the console
   window.
   
   @param time
   */
   public void skipTime( int time )
   {
      if( time < 1 )
         System.out.println("Time NOT updated with " + time + ".");
      else if( time == 1)
      {
         sim.noAction(time);
         System.out.println("Time updated by " + time + " time unit;"
                            + " current time is " + sim.getCurrentTime()
                            + ".");
      }
      else
      {
         sim.noAction(time);
         System.out.println("Time updated by " + time + " time units;"
                            + " current time is " + sim.getCurrentTime()
                            + ".");
      }
   }
   
   /**
   This method generates and displays the simulation statistics.
   */
   public void stats()
   {
      double average;
      if(sim.getAcWaited() == 0)
         average = 0;
      else
         average = (double) sim.getTWaitTime() / sim.getAcWaited();
      System.out.println("The average wait time for aircraft "
                         + "that finished waiting is " + average + ".");
      System.out.println("The total wait time is " 
                         + sim.getTWaitTime() + ".");
      System.out.println("The number of aircraft that took off is "
                         + sim.getTookOff() + ".");
      System.out.println("The number of aircraft did not have to wait"
                         + " is " + sim.getNoWait() + ".");
      System.out.println();
   }
   
   /**
   This method executes the final simulation statistics for the program.
   */
   public void endProgram()
   {
      System.out.println("Simulation statistics:");
      stats();
      System.out.println("Simulation terminated.");
   }
}
