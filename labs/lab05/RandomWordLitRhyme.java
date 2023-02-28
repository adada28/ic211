/**
 * The RandomWordLitRhyme class starts with a random word and prints 
 * a certain number of words that "rhyme" with is.
 * Rhyming in this case just means if the last two words are the same.
 * Extends the RandomWordLit class
 * @author MIDN 3/C Ayoo Dada
 */
public class RandomWordLitRhyme extends RandomWordLit{
    
    //private string that takes in the first word
    private String first;
    private boolean startWord = true;

    /**
      * This is a constructor for getting a random word
      * @param seed - The seed for the random words
      */
    public RandomWordLitRhyme(long seed){
        super(seed);
    }

    /**
      * This method returns an intital word and then only returns words that rhyme with it
      * @return Strings that rhyme
      */
    public String next(){
        if(startWord){
            String firstWord = super.next();
            this.startWord = false;
            int len = firstWord.length();
            this.first = firstWord;
            return firstWord;
        }
        else{
            String tempWord = super.next();
            while(!(first.substring(first.length() - 2).equals(tempWord.substring(tempWord.length() - 2)))){
                tempWord = super.next();
            }
            
            return tempWord;
        }
    }
}