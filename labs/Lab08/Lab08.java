import java.util.*;
import java.io.*;

public class Lab08 {
  /*
  public static void verboseMode(String fname, ModQueue Q){
    Scanner sc = null;
    try {
      sc = new Scanner(new FileReader(fname));
    } catch(IOException e) {
      e.printStackTrace();
      System.exit(1);
    }

    do {
          String cmd = sc.next();

          if( cmd.equals("quit") ) {
            break;
          } else if( cmd.equals("clearto") ) {
            Q.dequeue(sc.next());
          } else if( cmd.equals("add") )   {
            Q.enqueue(sc.next());
          } else if( cmd.equals("dump") )   {
            System.out.println(Q.dump());
          }
        } while( true );   
  }
  */
  public static void main(String[] args) throws Exception {
    Scanner  sc = new Scanner(System.in);
    ModQueue Q  = new ModQueue();

    boolean verbose = false;
    boolean hasFile = false;
    String fname;
    
    if(args.length == 1){
      if(args[0].equals("-v")){
        verbose = true;
      }
      else{
        hasFile = true;
        fname = args[0];
      }      
    }

    else if(args.length == 2){
      hasFile = true; 
      verbose = true;
      fname = args[1];
    }

    if(file == true){
      Scanner sc = null;
      try {
        sc = new Scanner(new FileReader(fname));
      } catch(IOException e) {
        //e.printStackTrace();
        //System.exit(1);
        file = false;
        System.out.println("File '" + fname + "' could not be opened; switching input to standard in.");
        sc = new Scanner(System.in);
      } 
    } 

    do {
      if(file == false){
        System.out.print("> ");
      } 
      
      
      String cmd = "";

      try{
        cmd = sc.next();
      }catch(Exception e){
        break;
      }
      if( cmd.equals("quit") ) {
        break;
      } else if( cmd.equals("clearto") ) {
        Q.dequeue(sc.next());
      } else if( cmd.equals("add") )   {
        Q.enqueue(sc.next());
      } 
      else if( cmd.equals("dump") )   {
        try{
          System.out.println(Q.dump());
        }
        catch(QueueException e){
          ;
        }
        
      }
    } while( true );  
          
    

  }
}
