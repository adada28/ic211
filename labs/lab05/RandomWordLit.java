import java.util.*;

/**
 * The RandomWordLit class starts with a random word and prints 
 * a certain number of words that start wtih the same letter.
 * Extends RandomWord class
 * @author MIDN 3/C Ayoo Dada
 */
public class RandomWordLit extends RandomWord {
    //boolean that helps differentiate starting word from others
    private boolean startWord = true;
    
    //char that will be referenced when comparing
    private char refchar;
    
    /**
     * This is a constructor for getting a random word
     * @param seed - The seed for the random words
     */   
    public RandomWordLit(long seed){
        super(seed);
    }

    /**
      * This method returns an intital word and then only returns words that start with the same letter
      * @return Strings that start with the same letter
      */
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