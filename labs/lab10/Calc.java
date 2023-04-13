import java.util.*;

/**
  * Calc class that does the calculation for cost and months
  * @author MIDN 3/C Ayoo Dada
 */
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

    /**
      * Method that calculates the cost
     */
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
        //System.out.println("months = " + months + " cost = " + cost);
        
    }

    /**
      * Getter for the cost
      * @return String
     */
    public String getCost(){
        String strcost = Double.toString(cost);
        return strcost;
    }

    /**
      * Getter for the months
      * @return String    
     */
    public String getMonths(){
        String strmonths = Double.toString(months);
        return strmonths;
    }

    public static void main(String[] args){
        Calc test = new Calc(4500.00, 4.25, 95.50);
        test.cost();

        Calc test1 = new Calc(4500.00, 7.25, 95.50);
        test1.cost();        
    }
}