import java.util.*;
public class RandomWordLit extends RandomWord {
    private boolean startWord = true;
    private char refchar;
    // Constructor for the class, requires a seed value.
    public RandomWordLit(long seed){
        super(seed);
    }
    // Returns a random word as a String.
    public String next(){
        if(startWord){
            String firstWord = super.next();
            this.startWord = false;
            this.refchar = firstWord.charAt(0); 
            return firstWord;
        }
        else{
            String tempWord = super.next();
            while(this.refchar != tempWord.charAt(0)){
                tempWord = super.next();
            }
            return tempWord;
        }
    }
}