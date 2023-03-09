/**
  * The MovingDot includes the step function and constructor of a
  * moving Dot
  * Extends Dot class
  * @author MIDN 3/C Dada
  */
public class MovingDot extends Dot{
    protected int direction;
   /**
      * This is a constructor for the Bluedot uses super to extract data from info
      * @param r - int value for row
      * @param c - int value for col
      */    
    public MovingDot(int r, int c){
        super(r,c);
        this.direction = 0;
    }

    /**
      * Step method that deals with setting integer values to specific directions
      */  
    public void step(){
        if(this.direction == 0){ //Up
            super.incRow();
        }
        else if(this.direction == 1){ //Up to the right
            super.incRow();
            super.incCol();
        }
        else if(this.direction == 2){ //Right
            super.incCol();
        }
        else if(this.direction == 3){ // Down to the right
            super.decRow();
            super.incCol();
        }
        else if(this.direction == 4){ // Down
            super.decRow();
        }
        else if(this.direction == 5){ // Down to the left
            super.decRow();
            super.decCol();
        }
        else if(this.direction == 6){ // Left
            super.decCol();
        }
        else if(this.direction == 7){ // Up to the left
            super.decCol();
            super.incRow();
        }
        
    }

}