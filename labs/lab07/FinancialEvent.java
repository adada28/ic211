import java.util.*;
import java.io.*;
import java.util.Calendar;


/**
 * Financial event class that is the parent class for all event types. 
 * It is also the class called for all "regular" events (ones with no stop date or probability).
 * Went to MGSP on 03/08/22 with MIDN 2/C Shannon Clancy for guidance 
 * Asked MIDN 3/C Anuj Sirsikar a few questions on the implementation
 * @author MIDN 3/C Ayoo Dada
 */
public class FinancialEvent{
    private String freq;
    private String task;
    private MyDate date;
    
    /**
      * Constructor for each singular event. 
      * @param f - (frequency)
      * @param d - (date)
      * @param t - (task)
      */
    public FinancialEvent(String f, String d, String t){
        this.freq = f;
        this.task = t;
        String datesplit[] = d.split("/");
        this.date = MyDate.makeDate(Integer.parseInt(datesplit[2]), Integer.parseInt(datesplit[0]), Integer.parseInt(datesplit[1]));
    }

    /**
      * Method that checks if event is happening on the current day
      * @param today - Today's date
      * @return bool 
      */
    public boolean eventHappening(MyDate today){
        if(this.date.daysUntil(today) == 0){
            this.setDate();
            return true; 
        }
        return false;
    }

    /**
      * Method that increments current date
      * @return void
      */
    private void setDate(){
        String incType[] = this.freq.split(" ");
        if(incType[1].equals("days")){
            date.incDay(Integer.parseInt(incType[0]));
        }
        else{
            date.incMonth(Integer.parseInt(incType[0]));
        }
    }

    /**
      * Method that retrieves String from event to print in main
      * @return String 
      */
    public String getTask(){
        return this.task; 
    }


    //

    public static void main(String[] args){
       // FinancialEvent t = new FinancialEvent;
    }
}