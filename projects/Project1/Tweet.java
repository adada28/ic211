/**
  * The Tweet class deals with one tweet from the user.
  * Uses a constructor to have multiple values in a Tweet
  * toString() method for formatting 
  * Contains Keyword and Contains Date method for comparisons 
  * @author Dada, Ayoo
  */
public class Tweet{
    private String nt;
    private String nuser;
    private String[] ndate;

    /**
      * The tweet constructor that puts all relevant values into one tweet
      * @param String newtext - this is the actual tweet the user typed
      * @param String newuser - the user's Twitter username
      * @param String newdate - the date the Tweet was sent in string format
      */
    public Tweet(String newtext, String newuser, String newdate){
        this.nt = newtext;
        this.nuser = newuser;
        this.ndate = newdate.split("-");
    }

    /**
      * The toString() method that formats the tweet into desired output
      * @return String - actual tweet
      */
    public String toString(){
        return this.nt + "\t" + '[' + this.nuser + ']' + "\t" + Integer.parseInt(this.ndate[1]) + '/' + Integer.parseInt(this.ndate[2]) + '/' + Integer.parseInt(this.ndate[0]);
    }
    
    /**
      * The containsKeyword method sees if a given word appears in a tweet.
      * Necessary for the filterForKeyword and filterForNotKeyword
      * methods in Queue.java
      * @return true if tweet contains the given keyword
      */
    public boolean containsKeyword(String keyword){
        String [] sentenceSplit= this.nt.split(" ");
        int size = sentenceSplit.length;
        for(int i = 0; i < size; i++){
            String oneword = sentenceSplit[i].toLowerCase();
            if(oneword.contains(keyword.toLowerCase())){
                return true;
            }         
        }
        return false;
    }

    /**
      * The containsDate method sees if a date matches one of a tweet.
      * Necessary for the filterForDatemethod in Queue.java
      * @return true if tweet contains the given date
      */
    public boolean containsDate(String date){
        String[] splitdate = date.split("-");
        return ((Integer.parseInt(this.ndate[0]) == Integer.parseInt(splitdate[0])) && (Integer.parseInt(this.ndate[1]) == Integer.parseInt(splitdate[1])) && (Integer.parseInt(this.ndate[2]) == Integer.parseInt(splitdate[2])));
    }

/** 
  * This is the main method that was used to test the initial Tweet
  * format and keyword test
  * @param String[] args
  * @return void 
  */
    public static void main(String[] args){
        Tweet test = new Tweet("hi what are you doing", "aed28", "1-30-2013");
        System.out.println(test.toString());

        if(test.containsKeyword("what")){
            System.out.println("true");
        }
    }
}