import java.util.Random;
/**
  * The GreenDot includes the step function, constructor, and toString of a
  * moving green Dot
  * Extends MovingDot class
  * @author MIDN 3/C Dada
  */

public class GreenDot extends MovingDot{
    //variable for random value
    private Random rand;

    /**
      * This is a constructor for the Greendot uses super to extract data from info
      * @param r - int value for row
      * @param c - int value for col
      */
    public GreenDot(int r, int c){
        super(r,c);
        this.rand = new Random();
    }
    
    /**
      * Step method that deals with movement of GreenDot
      */
    public void step(){
        //random num between 0 and 7
        int realdir = rand.nextInt(8);
        int savedir = realdir;
        
        //if direction is odd (moving diagoanl) stay for 10 counts
        if(realdir % 2 != 0){
            int ct = 0;
            while(ct != 10){
                super.direction = savedir;
                ct++;
            }
        }
        //if even only do 1 count
        else{
            super.direction = realdir;
        }
        
        super.step();
    }

    /**
      * toString method for formating dot pixel
      * @return String 
     */
    public String toString(){
        return super.toString() + " g";
    }
}