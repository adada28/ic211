import java.util.*;

public class Strings{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter your name: ");
    String a = sc.next();

    System.out.println("Welcome " + a);

    System.out.println("The first letter of your name is: " + a.charAt(0));

    System.out.println("Let's yell your name " + a.toUpperCase());

  }
}
