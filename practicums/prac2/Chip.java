import java.util.*;

public class Chip implements Piece{
    private boolean black;
    private int what;
    private Random temp;

    public Chip(Random r){
        black = false;
        what = 1;
        temp = r;
    }
    public void shake(){
        black = temp.nextBoolean();

        if(black){
            System.out.print("B");
        }
        else{
            System.out.print("W");
            }

    }

}