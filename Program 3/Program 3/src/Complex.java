
/**
 This class creates the complex number.
 This class holds all mathematical operations that will be done as well as
 the toString method. 
 @author knapp_000
 */
public class Complex 
{
   private int real;
   private int imag;

   /**
   Basic constructor for Complex
   */
   public Complex()
   {
      real = 0;
      imag = 0;
   }
   
   /** 
   Real constructor for complex. Puts param into real and 0 into imag. 
   @param a real number
   */
   public Complex (int a)
   {
      real = a;
      imag = 0;
   }
   
   /**
   Constructor for complex puts a param into real and b param into imag. 
   @param a real number
   @param b imag number
   */
   public Complex (int a, int b)
   {
      real = a;
      imag = b;
   }
   
   /**
   Adds Complex to cp. Adding real to cp.real and imag to cp.imag.
   @param cp complex being added to Complex.
   @return new complex of added result
   */
   public Complex plus (Complex cp)
   {
      return new Complex (real + cp.real , imag + cp.imag);
   }
   
   /**
   Subtracts cp from Complex. 
   @param cp complex to be subtracted.
   @return results of the subtraction
   */
   public Complex minus (Complex cp)
   {
      return new Complex (real - cp.real , imag - cp.imag);
   }
   
   /**
   Multiplies cp to Complex. 
   @param cp complex to be multiplied with Complex
   @return result of the multiplication
   */
   public Complex times (Complex cp)
   {
      return new Complex (real * cp.real - imag * cp.imag, real * cp.imag + 
            imag * cp.real);
   }
   
   /**
   Gets the conjugate of Complex. multiplies imag by -1
   @return conjugate of Complex
   */
   public Complex conjugate ()
   {
      return new Complex (real , imag * -1);
   }
   
   /**
   checks if the real and imag are the same for Complex from obj.
   @param obj Complex to be compared to Complex
   @return true if equal false if not.
   */
   public boolean equals (Object obj)
   {
      if( obj instanceof Complex)
      {
         Complex b = (Complex) obj;
         if (real == b.real)
         {
            if (imag == b.imag)
               return true;
         }
         return false;
      }
      return false;
   }
   
   /**
   Changes the answer from Complex into an answer string
   @return string of answer
   */
   public String toString()
   {
      if ( imag == 0)
      {
         if ( real == 0)
            return "0";
         else 
            return real + "";
      }
      else if ( imag == 1)
         if ( real == 0)
            return "i";
         else
            return real + "+i";
      else 
         if ( imag < 0)
            if ( imag == -1)
               if ( real == 0)
                  return "-i";
               else
                  return real + "-i";
            else
               if ( real == 0)
                  return imag + "i";
               else 
                  return real + "" + imag + "i";
         else
            if ( real == 0)
               return imag + "i";
            else   
               return real + "+" + imag + "i";
   }
}

