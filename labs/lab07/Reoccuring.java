/**
 * Reoccuring event class that is the child class for a Financial event. 
 * It is also the class called for all reoccuring events that have an increment amount and stop date.
 * Went to MGSP on 03/08/22 with MIDN 2/C Shannon Clancy for guidance 
 * Asked MIDN 3/C Anuj Sirsikar a few questions on the implementation
 * @author MIDN 3/C Ayoo Dada
 */

public class Reoccuring extends FinancialEvent{
    private int occ;
    private int taskAmt;
    
    /**
      * Constructor for reoccuring events. Uses super to call from parent class
      * @param f - (frequency)
      * @param d - (date)
      * @param t - (task)
      * @param o - (occurence amount)
      */
    public Reoccuring(String f, String d, String t, int o){
        super(f, d, t);
        this.occ = o;
        this.taskAmt = 0;
    }

    /**
      * Method that checks if event is happening on the current day
      * @param currdate - Today's date
      * @return bool 
      */
    public boolean eventHappening(MyDate currdate){
        //check if event is happening AND if the stop date has not passed
        if(super.eventHappening(currdate) && this.taskAmt < this.occ){
            this.taskAmt++;
            return true;
        }
        return false;
    }

}