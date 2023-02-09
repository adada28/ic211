import java.util.*;

public class Rotor{
    private String alphabet;
    private char topChar;

    public Rotor(String m, char top){
        this.alphabet = m; 
        this.topChar = top;

        while(this.topChar != this.alphabet.charAt(0)){
            rotate();
        }
    }

    public String toString(){
        return alphabet;
    }

    public void rotate(){

        char end = this.alphabet.charAt(26);
        
        String sub = this.alphabet.substring(0,26);

        this.alphabet = end+sub;

    }

    public int findIndex(char c){
        return this.alphabet.indexOf(c);
    }

    public char findChar(int index){
        return this.alphabet.charAt(index);
    }

    public static void main(String[] args){
        String t = "#GNUAHOVBIPWCJQXDKRYELSZFMT";
        //char top = findChar(0);

        Rotor x = new Rotor(t,t.charAt(0));
        x.rotate();
        System.out.println(x.toString());
    }
}
