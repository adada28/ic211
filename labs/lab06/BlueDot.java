import java.util.Random;
public class BlueDot extends MovingDot{
    Random rand;
    
    public BlueDot(int r, int c){
        super(r,c);
        this.rand = new Random();
    }
    public void step(){
        //int tempdir = rand.nextInt(3);

        super.direction = super.direction + (2*(rand.nextInt(3) - 1));

        if(super.direction == -2){
            super.direction = 6;
        }
        else if(super.direction == 8){
            super.direction = 0;
        }
        
        super.step();
    }

    public String toString(){
        return super.toString() + "b";
    }
}