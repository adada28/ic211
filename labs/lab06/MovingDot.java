public class MovingDot extends Dot{
    private int direction = 0;
    public MovingDot(int r, int c){
        super(r,c);
    }

    public void step(){
        if(this.direction == 0){
            super.incRow();
        }
        /*
        else if(this.direction == 1){
            super.incRow();
            super.incCol();
        }
        else if(this.direction == 2){
            super.incCol();
        }
        else if(this.direction == 3){
            super.decRow();
            super.incCol();
        }
        else if(this.direction == 4){
            super.decRow();
        }
        else if(this.direction == 5){
            super.decRow();
            super.decCol();
        }
        else if(this.direction == 6){
            super.decCol();
        }
        else if(this.direction == 7){
            super.decCol();
            super.incRow();
        }
        */
    }

    public static void main(String[] args){
        MovingDot x = new MovingDot(50,50);
        System.out.println(x);
    }
}