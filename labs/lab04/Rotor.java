import java.util.*;

/**
Rotor class creates one Rotor and contains the commands necessary for a 
Enigma cipher. These commands are rotate, findIndex, and, findChar
Guidance from 3/C Soleil Xie
@author - Dada, Ayoo 
 */
public class Rotor{
    private String alphabet;
    private char topChar;

    public Rotor(String m, char top){
        this.alphabet = m; 
        this.topChar = top;

        while(this.topChar != this.findChar(0)){
            rotate();
        }
    }

    public String toString(){
        return alphabet;
    }
/**
Method that rotates rotor by one clockwise. Puts last letter at the top
of the string.
 */
    public void rotate(){

        char end = this.findChar(26);
        
        String sub = this.alphabet.substring(0,26);

        this.alphabet = end+sub;

    }

/**
Finds index of specific character in string and returns that index value
@param - char
@return - int 
 */
    public int findIndex(char c){
        return this.alphabet.indexOf(c);
    }

/**
Similar to findIndex method, but returns char at a certain index value
@param - int
@return char
 */
    public char findChar(int index){
        return this.alphabet.charAt(index);
    }

//Main method for testing
    public static void main(String[] args){
        String t = "#GNUAHOVBIPWCJQXDKRYELSZFMT";
        //char top = findChar(0);

        Rotor x = new Rotor(t,t.charAt(0));
        x.rotate();
        System.out.println(x.toString());
    }
}
