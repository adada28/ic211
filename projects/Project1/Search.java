import java.io.*;
import java.util.*;

/**
  * The purpose of the Search class is to read in the file of tweets
  * and puts each tweet into a Queue linked list. Also, it takes in the
  * input of the user and runs the overall program. 
  * @author Dada, Ayoo
  */
public class Search{
  public static void main(String[] args){
    
    //initialize the tweet and choice to 0
    int tweetAmt = 0;
    String choice = " ";

    //create initial Queue that takes in file values
    Queue Q = new Queue();

    //error if file argument isn't inputted
    if( args.length != 1 ) {
        System.out.println("usage: java Search <tweets-file>");
        System.exit(1);
    }
    String fname = args[0];
    
    //lopens file and loops to take in tweets from file and store in queue
    Scanner sc = null;
    try{
      sc = new Scanner(new FileReader(fname));
    }catch(IOException e){
      e.printStackTrace();
      System.exit(1);
    }
    while(sc.hasNext()){
        String temp = sc.nextLine();
        String[] strTweet = temp.split("\t");
        Tweet oneTweet = new Tweet(strTweet[0], strTweet[1], strTweet[2]);
        Q.enqueue(oneTweet);
        tweetAmt = Q.length();
    }

    //Sets a copy queue name keywordqueue of the original queue to prevent modifying 
    Queue keywordQueue = Q;
    Scanner c = new Scanner(System.in);
    
    //Main program loop
    while(!choice.equals("!quit")){
        System.out.println("Queue size: " + tweetAmt);
        System.out.print("? ");
        choice = c.next();
        
        if(choice.charAt(0) == '!'){
          if(choice.equals("!dump")){
              keywordQueue.printAll();
          }
          else if(choice.equals("!reset")){
            keywordQueue = Q;
            tweetAmt = keywordQueue.length();
          }
        }
        
        else if(choice.charAt(0) == '-'){
          keywordQueue = keywordQueue.filterForNotKeyword(choice.substring(1));
          tweetAmt = keywordQueue.length();
        }
        
        else if(choice.charAt(0) == '+'){
          keywordQueue = keywordQueue.filterForDate(choice.substring(1));
          tweetAmt = keywordQueue.length();
        }
        
        else{
          keywordQueue = keywordQueue.filterForKeyword(choice);             
          tweetAmt = keywordQueue.length();          
        }
    }

    //Program End
    System.out.println("Goodbye!");
  
  }
}