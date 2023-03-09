import java.util.Random;
/**
  * The BlueDot includes the step function, constructor, and toString of a
  * moving blue Dot
  * Extends MovingDot class
  * help from 3/C Wieland
  * @author MIDN 3/C Dada
  */

public class BlueDot extends MovingDot{
    private Random rand;
    private int count = 0;
    
   /**
      * This is a constructor for the Bluedot uses super to extract data from info
      * @param r - int value for row 
      * @param c - int value for col
      */    
    public BlueDot(int r, int c){
        super(r,c);
        this.rand = new Random();
    }

    /**
      * Step method that deals with movement of BlueDot
      */    
    public void step(){
        //change direction left right or up every 10 steps
        this.count++;
        if(this.count % 10 == 0){
            super.direction = super.direction + (2*(rand.nextInt(3) - 1));
            this.count = 0; 
        }
        
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
        return super.toString() + " b";
    }
}