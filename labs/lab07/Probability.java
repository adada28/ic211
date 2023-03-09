import java.util.Random;
/**
 * Probability event class that is the child class for a Financial event. 
 * It is also the class called for all Probability events that have a ratio for chance that something happens.
 * Went to MGSP on 03/08/22 with MIDN 2/C Shannon Clancy for guidance 
 * Asked MIDN 3/C Anuj Sirsikar a few questions on the implementation
 * @author MIDN 3/C Ayoo Dada
 */

public class Probability extends FinancialEvent{
    private double prob;
    private Random rand;
    
    /**
      * Constructor for probability events. Uses super to call from parent class
      * @param f - (frequency)
      * @param d - (date)
      * @param t - (task)
      * @param p - (probability ratio)
      * @param r - (random value)
      */    
    
    public Probability(String f, String d,  String t, double p, Random r){
        super(f, d, t);
        this.prob = p;
        this.rand = r;
    }

    /**
      * Method that checks if event is happening on the current day. Accounts for probability
      * @param currdate - Today's date
      * @return bool 
      */    
    public boolean eventHappening(MyDate currdate){
        if(super.eventHappening(currdate)){
            if(this.rand.nextDouble() <= this.prob){
                return true;
            }
        }
        return false;
    }

    //
}