//Ayoo Dada


import java.util.*;

public class Game {
  public static void main(String[] args) {
    int seed = 0;
    if( args.length == 1 )
      seed = Integer.parseInt(args[0]);

    Random r = new Random(seed);
    boolean ball = r.nextBoolean();
    Piece[] P = new Piece[3];
    
    P[0] = new Ball(ball);
    P[1] = new Chip(r);
    P[2] = new Die(r, 2, 4);

    
    for( int j = 0; j < 10; j++ ) {
      for( int i = 0; i < P.length; i++ ) {
        if(i == 0){
            P[0].shake();
        }
        else if(i == 1){
            P[1].shake();
        }
        else if(i == 2){
            P[2].shake();
        }
      }
      System.out.println();
    }
  }
}