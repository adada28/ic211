import java.util.*;
public class Lab1b {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = in.nextLine();
        System.out.print("Please input an integer: ");
        int n = in.nextInt();
        System.out.print("Please input a second integer: ");
        int k = in.nextInt();
        System.out.println("The two ints were " + n + " and " + k);

        int num = 1;
        int t = k - 1;
        for(int i = 0; i < k; i++){
            int tem = n - i;
            num = num*tem;   
        }

        int den = 1;
        for(int j = 1; j < k+1; j++){
            den = den * j;
        }

        System.out.println("numerator = " + num);
        System.out.println("denominator = " + den);

        int lowodd = den/den;
        int highodd = num/den;
        double dec = (double)den/num;
        System.out.println("odds = " + lowodd + " in " + highodd + " = " + dec);

        System.out.println("Goodbye " + name + ".");
    }
}
