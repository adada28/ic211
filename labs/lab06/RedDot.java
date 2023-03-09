import java.util.Random;
/**
  * The RedDot includes the step function, constructor, and toString of a
  * moving red Dot
  * Extends MovingDot class
  * help from 3/C Wieland
  * @author MIDN 3/C Dada
  */
public class RedDot extends MovingDot{
    Random rand;
    
   /**
      * This is a constructor for the RedDot uses super to extract data from info
      * @param r - int value for row
      * @param c - int value for col
      */       
    public RedDot(int r, int c){
        super(r,c);
        this.rand = new Random();
    }

    /**
      * Step method that deals with movement of BlueDot
      */        
    public void step(){
        //randomize values between 0 and 7. Each value corresponds to a direction in MovingDot
        super.direction = super.direction + (2*(rand.nextInt(3) - 1));

         //if direction goes below 0 set it to 6 which is left
        if(super.direction == -2){
            super.direction = 6;
        }


        //if direction goes above 7 set to 0 which is up
        else if(super.direction == 8){
            super.direction = 0;
        }
        super.step();
    }

   /**
      * toString method for formating dot pixel
      * @return String 
     */
    public String toString(){
        return super.toString() + " r";
    }
}