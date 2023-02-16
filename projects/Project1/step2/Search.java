import java.io.*;
import java.util.*;

public class Search{
  public static void main(String[] args){
    int tweetamt = 0;
    
    Queue Q = new Queue();

    if( args.length != 1 ) {
        System.out.println("usage: java Search <tweets-file>");
        System.exit(1);
    }
    String fname = args[0];
    Scanner sc = null;
    try{
      sc = new Scanner(new FileReader(fname));
    }catch(IOException e){
      e.printStackTrace();
      System.exit(1);
    }
    
    while(sc.hasNext()){
        String temp = sc.nextLine();
        String[] strtweet = temp.split("\t");
        Tweet onetweet = new Tweet(strtweet[0], strtweet[1], strtweet[2]);
        Q.enqueue(onetweet);
        tweetamt = Q.length();
    }
    

    System.out.println("Queue size: " + tweetamt);

    Q.printAll(Q);
  }
}