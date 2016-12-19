
/**
 Aircraft class has aircraft characteristics and a toString to display 
 arrival. 
 @author knapp_000
 */
public class Aircraft 
{
   private static int numAircraft = 0;
   private int aircraftNo;
   private int timeStamp;
   
   /**
   Default constructor for Aircraft.
   @param time timestamp when aircraft arrived 
   */
   public Aircraft(int time)
   {
      numAircraft++;
      aircraftNo = numAircraft;
      timeStamp = time;
   }
   
   /**
   Returns timeStamp
   @return int timeStamp
   */
   public int getTimestamp()
   {
      return timeStamp;
   }
   
   /**
   Returns a string with the aircraftNo and timestamp.
   @return string
   */
   public String toString()
   {
      return "Aircraft#" + aircraftNo + " arrived @time " + timeStamp;
   }
}
