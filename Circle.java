import ou.*;
/**
 * The class Circle defines a shape with the characteristics of a circle.
 *
 * @author M250 Module Team
 * @version 2.0
 */

public class Circle extends OUAnimatedObject
{
   /* Instance variables */
   private OUColour colour;
   private int xPos;
   private int yPos;
   private int diameter;

   /**
    * Zero argument constructor for objects of class Circle 
    * that sets colour to OUColour.BLUE, 
    * xPos and yPos to 0,.and diameter to 30, 
    */
   public Circle()
   {
      super();
      this.colour = OUColour.BLUE;
      this.xPos = 0;
      this.yPos = 0;
      this.diameter = 30;
   }

   /**
    * Constructor for objects of class Circle with arguments for
    * diameter and colour, and which sets xPos and yPos to 0.
    */
   public Circle(int aDiameter, OUColour aColour)
   {
      super();
      this.diameter = aDiameter;
      this.colour = aColour;
      this.xPos = 0;
      this.yPos = 0;
   }

   /* Instance methods */    

   /**
    * Sets the diameter of the receiver to the value of the argument aDiameter.
    */
   public void setDiameter(int aDiameter)
   {
      this.diameter = aDiameter;
      this.update();
   }

   /**
    * Returns the diameter of the receiver.
    */
   public int getDiameter()
   {
      return this.diameter;
   }

   /**
    * Sets the colour of the receiver to the value of the argument aColour.
    */
   public void setColour (OUColour aColour)
   {
      this.colour = aColour;
      this.update();
   }

   /**
    * Returns the colour of the receiver.
    */
   public OUColour getColour ()
   {
      return this.colour;
   }

   /**
    * Sets the horizontal position of the receiver to the value of the argument x.
    */
   public void setXPos(int x)
   {
      this.xPos = x;
      this.update();
   }

   /**
    * Returns the horizontal position of the receiver.
    */
   public int getXPos()
   {
      return this.xPos;
   }

   /**
    * Sets the vertical position of the receiver to the value of the argument y.
    */
   public void setYPos(int y)
   {
      this.yPos = y;
      this.update();
   }

   /**
    * Returns the vertical position of the receiver.
    */
   public int getYPos()
   {
      return this.yPos;
   }

   /**
    * Returns a string representation of the receiver.
    */
   public String toString()
   {
      return "An instance of class " + this.getClass().getName() 
      + ": position (" + this.getXPos() + ", " + this.getYPos() 
      + "), diameter " + this.getDiameter() + ", colour " + this.getColour();
   }
}
