import java.util.*;

public class Die implements Piece{
  // only for what=2
  private boolean black;
  private int what;
  private int numBlack;
  private int numWhite;
  private Random temp;
  
    public Die(Random r, int nB, int nW){
        black = false;
        what = 0;
        numBlack = nB;
        numWhite = nW;
        temp = r;
    }
  
    public void shake(){
        int k = temp.nextInt(numBlack + numWhite);
        black = k < numBlack;

        if(black){
            System.out.print("B");
        }
        else{
            System.out.print("W");
            }
    }


}