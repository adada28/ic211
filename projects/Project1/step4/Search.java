import java.io.*;
import java.util.*;

public class Search{
  public static void main(String[] args){
    int tweetamt = 0;
    
    String choice = " ";

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
    Queue keywordqueue = Q;
    Scanner c = new Scanner(System.in);
    while(!choice.equals("!quit")){
        System.out.println("Queue size: " + tweetamt);
        System.out.print("? ");
        
        
        choice = c.next();
        if(choice.charAt(0) == '!'){
          if(choice.equals("!dump")){
              keywordqueue.printAll();
          }
        }
        else if(choice.charAt(0) == '-'){
          keywordqueue = keywordqueue.filterForNotKeyword(choice.substring(1));
          tweetamt = keywordqueue.length();
        }
        else{
          keywordqueue = keywordqueue.filterForKeyword(choice);             
          tweetamt = keywordqueue.length();          
        }
    }
    
    System.out.println("Goodbye!");

  }
}