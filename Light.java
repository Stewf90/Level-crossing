import ou.*;
/**
 * Light for TMA03Q1.
 * 
 * @author M250 module team solution 
 * @version 1.0
 */
public class Light extends Circle
{
   /**
    * Constructor for objects of class Light
    */
   public Light()
   {      
      this.setColour(OUColour.RED);
      this.setDiameter(50);      
   }

   /**
    * setColour sets the colour of the light if the argument is OUColour.RED, 
    * OUColour.GREEN, OUColour.ORANGE or OUColour.BLACK. 
    * Otherwise it does not change the colour 
    */
   public void setColour(OUColour colour)
   {
      if (colour.equals(OUColour.RED) || colour.equals(OUColour.GREEN)
      || colour.equals(OUColour.ORANGE) || colour.equals(OUColour.BLACK))
      {
         super.setColour(colour);
      }
   }
}

