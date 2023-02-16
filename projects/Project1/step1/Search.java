import java.io.*;
import java.util.*;

public class Search{
  
  public static Tweet[] readFile(String path){
    Scanner sc = null;
    try{
      sc = new Scanner(new FileReader(path));
    }catch(IOException e){
      e.printStackTrace();
      System.exit(1);
    }
    
     
    Tweet[] alltweets= new Tweet[33];

    for(int i = 0; i < 33; i++){
        if(sc.hasNext()){
            String temp = sc.nextLine();
            String[] strtweet = temp.split("\t");
            Tweet onetweet = new Tweet(strtweet[0], strtweet[1], strtweet[2]);
            alltweets[i] = onetweet;
            }
        }
  
    return alltweets; 
    
  }

  public static void main(String[] args){
    if( args.length != 1 ) {
        System.out.println("usage: java Search <tweets-file>");
        System.exit(1);
    }
    String fname = args[0];
    Tweet[] tweetlist = readFile(fname);

    System.out.println("Array size: " + tweetlist.length);
    for(int i = 0; i < 33; i++){
        System.out.println(tweetlist[i].toString());
    }
  }
}