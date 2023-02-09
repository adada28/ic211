public class RandomWordLitRhyme extends RandomWordLit{
    private char seclastchar;
    private char lastchar;
    private boolean stardWord;

    public RandomWordLitRhyme(long seed){
        super(seed);
    }

    public String next(){
        if(startWord){
            String firstWord = super.next();
            this.startWord = false;
            this.refchar = firstWord.charAt(0); 
            int len = tempWord.length();
            this.seclastchar = tempWord.charAt(len-2);
            this.lastchar = tempWord.charAt(len-1);
            return firstWord;
        }
        else{
            String tempWord = super.next();
            int len = tempWord.length();
            this.seclastchar = tempWord.charAt(len-2);
            this.lastchar = tempWord.charAt(len-1);
            while(this.refchar != tempWord.charAt(0)){
                tempWord = super.next();
            }
            return tempWord;
        }
    }
}