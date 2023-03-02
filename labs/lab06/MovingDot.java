public class MovingDot extends Dot{
    protected int direction;
    public MovingDot(int r, int c){
        super(r,c);
        this.direction = 0;
    }

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
/*
    public static void main(String[] args){
        MovingDot x = new MovingDot(50,50);
        System.out.println(x);
    }
    */
}