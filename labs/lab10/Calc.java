import java.util.*;

public class Calc{
    private double amt;
    private double rate;
    private double payment;
    private int months = 0;
    private double interest;
    private double cost; 

    public Calc(double a, double r, double p){
        this.amt = a;
        this.rate = r;
        this.payment = p;
    }


    public void cost(){
        while(amt > 0){
            months++;
            interest = (amt * rate)/1200;
            cost += interest;
            amt = amt + interest;
            amt = amt - payment;
        }

        cost *= 100;
        cost = Math.round(cost);
        cost /= 100;
        System.out.println("months = " + months + " cost = " + cost);
        
    }

    public static void main(String[] args){
        Calc test = new Calc(4500.00, 4.25, 95.50);
        test.cost();

        Calc test1 = new Calc(4500.00, 7.25, 95.50);
        test1.cost();        
    }
}