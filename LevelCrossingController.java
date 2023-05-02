import ou.*;
/**
 * LevelCrossingController for TMA03Q1.
 * 
 * Stewart Fitzpatrick
 * 19/04/2021
 */
public class LevelCrossingController
{  
   private Light topLeft;
   private Light topRight;
   private Light bottom;
   private int state; //  The current way the lights are
   private boolean trainComing;
   public static final int MIN_REPEATS = 4; 
   /**
    * Constructor for objects of class LevelCrossingController
    */
   public LevelCrossingController(Light oneLight, Light twoLight, Light threeLight)
   {
      this.topLeft = oneLight;
      this.topRight = twoLight;
      this.bottom = threeLight;
      setPositions();
      colourAllLights();
      state = 0; 
      trainComing = false;
   }

   /**
    * Changes the colour of the lights based on what state it is in and if train is coming 
    */
   public void changeState()
   {if ((trainComing == true) && (this.state < 3))
      {
         this.state = this.state + 1;
      }
      else if ((trainComing == true) && (this.state == 3))
      {
         this.state = this.state - 1;
      }
      else 
      {
         this.state = 0;
      }
   }

   /**
    * Sets the colour of all three lights based on the number state it is in
    */
   public void colourAllLights()
   {if (this.state == 3)
      {
         this.topLeft.setColour(OUColour.BLACK);
         this.topRight.setColour(OUColour.RED); 
         this.bottom.setColour(OUColour.BLACK);
      }

      else if (this.state == 2)
      {
         this.topLeft.setColour(OUColour.RED);
         this.topRight.setColour(OUColour.BLACK); 
         this.bottom.setColour(OUColour.BLACK);
      }

      else if (this.state == 1)
      {
         this.topLeft.setColour(OUColour.BLACK);
         this.topRight.setColour(OUColour.BLACK); 
         this.bottom.setColour(OUColour.ORANGE);
      }

      else
      {
         this.topLeft.setColour(OUColour.BLACK);
         this.topRight.setColour(OUColour.BLACK); 
         this.bottom.setColour(OUColour.BLACK);
      }
   } 

   /**
    * @return trainComing
    */
   public boolean getTrainComing()
   {
      return trainComing;
   }

   /**
    *  Setter for colour of a train light
    */
   public void colourLight(Light aLight, OUColour aColour)
   {
      aLight.setColour(aColour);
   }

   /**
    * @param trainComing
    * setter for trainComing
    */
   public void setTrainComing(boolean trainComing)
   {
      this.trainComing = trainComing;
   }

   /**
    * Sets the positions of the lights.
    */
   private void setPositions() 
   {
      this.bottom.setXPos(100);
      this.bottom.setYPos(200);      
      this.topLeft.setXPos(0);
      this.topLeft.setYPos(100);      
      this.topRight.setXPos(200);
      this.topRight.setYPos(100);
   }   

   /**
    * Find out how many times red lights should flash at the crossing.
    * Simulates length of train at crossing.
    */   
   public static int findNumRepeats()
   {
      int repeats = 0;

      boolean loop = true;
      String timesAsString = OUDialog.request("How many times should the red lights"
            + " flash? ("
            + LevelCrossingController.MIN_REPEATS
            + " or over times)");

      while (loop) {

         if (timesAsString == null)
         {
            loop = false;
            return 0;
         }  
         try 
         {
            repeats = Integer.parseInt(timesAsString);
            loop = false;

         }
         catch (NumberFormatException anException)
         {
            OUDialog.alert("The string you entered is not an appropriate integer");

            loop = true;
            timesAsString = OUDialog.request("How many times should the red lights"
               + " flash? ("
               + LevelCrossingController.MIN_REPEATS
               + " or over times)");
         }
         if ((repeats < MIN_REPEATS) && (loop == false))
         {

            OUDialog.alert("Entered integer is too low. Only numbers 4 and over are allowed");
            loop = true;
            timesAsString = OUDialog.request("How many times should the red lights"
               + " flash? ("
               + LevelCrossingController.MIN_REPEATS
               + " or over times)");
         }
      }

      return repeats;}

   /**
    * Asks the user how many times the train lights should flash and raises or lowers the barrier
    */
   public void doTrainApproaching()
   {

      System.out.println("Train approaching");
      this.trainComing = true;
      this.state = 1;
      colourAllLights();
      System.out.println("Barrier lowered");
      int numRepeats = findNumRepeats();

      while (numRepeats != 0){

         {
            if (numRepeats > 1){
            numRepeats --;
            changeState();
            colourAllLights();
            delay(300);
            }
            changeState();
            colourAllLights();
            delay(300);
            numRepeats --;
         }
      }
      this.trainComing = false;
      if (this.trainComing == false)
      {
         this.state = 0;
         colourAllLights();
         System.out.println("Barrier raised");
      }
   }

   /**
    * Causes execution to pause for a number of milliseconds.
    */
   public static void delay(int time)
   {
      try
      {
         Thread.sleep(time); 
      }
      catch (Exception e)
      {
         System.out.println(e);
      } 
   }
}

