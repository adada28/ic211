import java.util.*;
import java.io.*;

/**
  * The Lab07 class that contains the drive main method for the program.
  * Deals with all the input and arguments needed to run.
  * @author MIDN 3/C Ayoo Dada
  *
  */
public class Lab07{
    public static void main(String[] args){
        //if the program is run with fewer than two arguments print error message and exit
        if(args.length < 2){
            System.out.println("usage: java Lab07 <infilename> <numDays>");
            System.exit(1);
        }

        // create a random object for use
        Random rand;
        if( args.length == 3 )
            rand = new Random(Long.parseLong(args[2]));
        else
            rand = new Random(System.currentTimeMillis());        

        int linenum = 0;
        Scanner sc = null;
        try{
            sc = new Scanner(new File(args[0]));
            // put the call to file line counter
            linenum = FileLineCounter.countLines(args[0]); 
            // in this scope as well
            }catch(Exception e){
                e.printStackTrace();
                System.exit(1);
            }

        FinancialEvent[] tasklist = new FinancialEvent[linenum]; 

        //for loop that puts everytask in a list of events
        //uses polymorphism to separate events into respective class calls 
        for(int i = 0; i < linenum; i++){
            String task = sc.nextLine();
            String[] t = task.split(" ");

            String freq = t[1].concat(" "+t[2]);
            String date = "";
            String todo = "";
            Double prob = 0.0;
            int occ = 0;

            if(t[3].equals("start")){
                date = t[4];
                
                if(t[5].equals("prob")){
                    prob = Double.parseDouble(t[6]);
                    for(int j = 8; j < t.length; j++){
                        todo = todo + " " + t[j];
                    }
                    tasklist[i] = new Probability(freq, date, todo, prob, rand);                       
                }
                else{
                    for(int j = 6; j < t.length; j++){
                        todo = todo + " " + t[j];
                    }                    
                    tasklist[i] = new FinancialEvent(freq, date, todo);
                }
            }
            else if(t[3].equals("for")){
                occ = Integer.parseInt(t[4]);
                date = t[6];
                for(int j = 8; j < t.length; j++){
                    todo = todo + " " + t[j];
                }     
                tasklist[i] = new Reoccuring(freq, date, todo, occ);           
            }

        }

        //variables that help check days tasks have happened
        int numDaysToSimulate = Integer.parseInt(args[1]);
        int datecount = 0;
        int tasknum = 0;
        boolean somethingHappened = false;

        
        // set "today" to 1/1/2017
        MyDate today = new MyDate(2017, 1, 1);
        
        
        for( int i=0; i < numDaysToSimulate; i++ ) {
            
            // for loop that asks each event whether they have something going on "today"       
            // and if any do, print them out          
            for(int j = 0; j < tasklist.length; j++){
                
                if(tasklist[j].eventHappening(today)){
                    tasknum++;

                    //prints comma for formatting purposes
                    if (tasknum != 1){
                        System.out.print(",");
                    }

                    //eventHappened set to true for logic purposes
                    somethingHappened = true;
                    
                    if(datecount == 0){
                        datecount++;
                        System.out.print(today + ":"); 
                    } 
                    System.out.print(tasklist[j].getTask()); 
                }
                
            }
            
            datecount = 0;   
            tasknum = 0;  

            // increment "today"
            today.incDay(1);
            if(somethingHappened){
                System.out.println();
                somethingHappened = false;
            }
            
        }
            
    }
}