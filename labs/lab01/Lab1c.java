import java.util.*;
public class Lab1c{
    public static void main(String[] args){
        Random rand = new Random(42);

        int k = 11;
        int randnum = rand.nextInt(k);

        Scanner in = new Scanner(System.in);

        int guess = 1;
        
        System.out.print("Guess a number between 0 and 10: ");
        int i = in.nextInt(); 

        while(i != randnum){
            System.out.print("Sorry! Guess Again: ");
            i = in.nextInt();
            guess++;
        }

        System.out.println("Right after " + guess + " guesses!");
    }
}