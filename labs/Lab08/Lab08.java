import java.util.*;
import java.io.*;

/**
  * The Lab08 class that contains the drive main method for the program.
  * Deals with all the input and arguments needed to run.
  * Contains all the exceptions for each error example
  * Attended MGSP with 2/C Shannon Clancy
  * Collaborated with 3/C Shawn Berrios
  * @author MIDN 3/C Ayoo Dada
  *
  */
public class Lab08 {
  public static void main(String[] args) throws Exception {
    ModQueue Q  = new ModQueue();
    
    //Checks if user inputs a file or wants verbose mode
    boolean verbose = false;
    boolean hasFile = false;
    String fname = "";
    
    //If argument length is one it has to be either a -v or file name
    if(args.length == 1){
      if(args[0].equals("-v")){
        verbose = true;
      }
      else{
        hasFile = true;
        fname = args[0];
      }      
    }

    //if argument length is 2 it has to be both verbose mode with a file
    else if(args.length == 2){
      hasFile = true; 
      verbose = true;
      fname = args[1];
    }
    
    Scanner sc = null;
    sc = new Scanner(System.in);
    if(hasFile == true){
      
      //try catch for unknown file name
      try {
        sc = new Scanner(new FileReader(fname));
      } catch(IOException e) {
        hasFile = false;
        System.out.println("File '" + fname + "' could not be opened; switching input to standard in.");
        sc = new Scanner(System.in);
      } 
    } 

    do {
      if(hasFile == false){
        System.out.print("> ");
      } 
            
      String cmd = "";
    
    //try catch for no next word
      try{
        cmd = sc.next();
      }catch(Exception e){
        break;
      }
      if( cmd.equals("quit") ) {
        break;
      } else if( cmd.equals("clearto") ) {
        String word = sc.next();
        
        //try catch for checking if word is in the queue
        try{
          Q.dequeue(word);  
        }catch(QueueException e){
          if (verbose == true){
            System.out.println("String '" + word + "' not found!");
          }
        }
        
      } else if( cmd.equals("add") )   {
        try{
          if(sc.hasNext()){
            Q.enqueue(sc.next());
          }else{
            throw new EOFException("Unexpected end of input.");
          }
          
        }
        catch(EOFException eofe){
          System.out.println(eofe.getMessage());
          System.exit(1);
        }
      } 
      else if( cmd.equals("dump") )   {
        try{
          System.out.println(Q.dump());
        }
        catch(QueueException e){
          ;
        }
        
      }
      else{
        if(verbose == true){
          System.out.println("Unknown command '" + cmd + "'.");
        }
      }
    } while( true );  
          
    

  }
}
