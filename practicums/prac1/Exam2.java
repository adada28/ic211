import java.io.*;
import java.util.*;

public class Exam2{
    public static void main(String[] args){
        Queue mids = new Queue();

        if( args.length != 1 ) {
            System.out.println("usage: java Search <tweets-file>");
            System.exit(1);
        }
        String fname = args[0];
        Scanner sc = null;
        try{
        sc = new Scanner(new FileReader(fname));
        }catch(IOException e){
        e.printStackTrace();
        System.exit(1);
        }
        
        while(sc.hasNext()){
            String temp = sc.nextLine();
            String[] stats = temp.split(" ");
            Midshipman boxstats = new Midshipman(stats[0], stats[2], stats[1], Double.parseDouble(stats[3]), Double.parseDouble(stats[4]) , Double.parseDouble(stats[5]), Double.parseDouble(stats[6]));
            mids.enqueue(boxstats);
            int midamt = mids.length();
            System.out.println(stats[0] + ": " + stats[2] + ", " + stats[1]);
        }

        System.out.println("Now the matchups!!!");

        while(mids.empty() != true){
            Midshipman mid1 = mids.dequeue();
            Midshipman mid2 = mids.dequeue();

            System.out.println(mid1.alpha + ": " + mid1.lastn + ", " + mid1.firstn + " VS " + mid2.alpha + ": " + mid2.lastn + ", " + mid2.firstn);

            if(mid1.willBeat(mid2)){
                System.out.println(mid1.toString());
            }
            else{
                System.out.println(mid2.toString());
            }

        }



    }
}