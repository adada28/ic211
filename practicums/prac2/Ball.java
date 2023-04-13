import java.util.*;

public class Ball implements Piece{
    private static boolean black;
    private int what;
    
    public Ball(boolean r){
        black = r;
        what = 0;
    }
    
    public void shake(){
        if(black){
            System.out.print("B");
        }
        else{
            System.out.print("W");
            }
    }
          



}