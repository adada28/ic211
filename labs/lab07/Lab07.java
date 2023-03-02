import java.util.*;
import java.io.*;
public class Lab07{
    public static void main(String[] args){
        Scanner sc = null;
        try{
            sc = new Scanner(new File(args[0]));
            // put the call to file line counter
            int linenum = FileLineCounter.countLines(args[0]); 
            // in this scope as well
            }catch(Exception e){
                e.printStackTrace();
                System.exit(1);
            }


            // set "today" to 1/1/2017
            MyDate today = new MyDate(2017, 1, 1);
            for( int i=0; i < numDaysToSimulate; i++ ) {
            // ask each event whether they have something going on "today"
            
            // if any do, print them out

            // increment "today"
            //today.incDay(1);
            }
            
    }
}