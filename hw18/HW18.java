//Ayoo Dada
//HW18
//Collaborated with 3/C Berrios
import java.util.*;
import java.io.*;

public class HW18 {
  public static void main(String[] args) throws Exception{
    Scanner sc = null;
    Mystery myster = new Mystery();
    
    if(args.length == 0){
        Reader r = new InputStreamReader(System.in);
        sc = new Scanner(r);        
    }
    else{
       LineNumberReader numReader = new LineNumberReader(new InputStreamReader(new FileInputStream(args[0])));
        String line = numReader.readLine();
        while(line != null){
            sc = new Scanner(line);
            line = numReader.readLine();
            try{
                myster.compute(sc);
            } catch (Exception e) {
                int linenumb = numReader.getLineNumber();
                linenumb--;
                System.out.print("Error on line " + linenumb + ": " + e.getMessage());
                System.exit(1);
            }
        } 
    }

    

    try {
      myster.compute(sc); // can be called multiple times to continue computation
      System.out.println(myster.result()); // only called once after all compute() calls are finished
    } catch( Exception e ) {
      System.out.println("Error " + e.getMessage());
    }
  }
}