/**
  The Vault class is the driver for Parts 3 through 5 contains many methods
  as well as a main in order to check a person's username and password to 
  give access to manipulate the file. If the username and password the user enters
  are within the file. Access will be granted and they can use commands such as get or labels 
  to retrive information from the file. Quit will exit the program.
  @author MIDN 3/C Ayoo Dada
 */

import java.util.*;
import java.io.*;
import java.io.PrintWriter;

public class Vault{
    /**
      This is the main method for the Vaule Class and is the main driver for the program
      @param args - gets information user types to start the program 
     */
    public static void main(String[] args) throws Throwable{
        //initialized variables that will be important for the general program
        String fname = "";
        int logincount = 0;
        Scanner sc = null;
        boolean adduser = false;
        boolean auth = false;       
        ArrayList<Hasher> E = new ArrayList<Hasher>();

        //add the Hasher types to the ArrayList
        E.add(new ShiftCaesar());
        E.add(new ShiftVigenere());
        E.add(new ShiftClear());
        
        //if initial format is not right print usage message and exit
        if( args.length == 0 || args.length > 2 ) {
            System.out.println("usage: java Vault [-au] <filename>");
            System.exit(1);
        }

        //checks to see if user is to be added to the file  
        if (args[0].equals("-au")){
            adduser = true;
            fname = args[1];

        }
        else{
            auth = true;
            fname = args[0];
        }

        //checks to see if file is availiable and can be opened
        try{
            sc = new Scanner(new FileReader(fname));
        }catch(IOException e){
            //e.printStackTrace();
            System.out.println("Error! File '" + fname + "' could not be opened.");
            System.exit(1);
        }        

        //checks if data in file is properly formatted
        formatChecker(fname);
        
        //if auth is true go to Authentication method
        if(auth){
            Authentication(fname, sc); 
        }

        //else go to add user method
        else if(adduser){
            newUser(fname, sc);
        }  
    }

   /**
     This method checks if the password the user input matches a password in the file and returns 
     true if passwords match. False is returned if passwords do no match
     @param type - encryption type
     @param correctPass - correct password in file 
     @param inputpass - password inputted by user 
     @return boolean 
    */ 
   public static boolean correctPassword(String type, String correctPass, char[] inputpass) throws Throwable{
        ArrayList<Hasher> E = new ArrayList<Hasher>();
        E.add(new ShiftCaesar());
        E.add(new ShiftVigenere());
        E.add(new ShiftClear());   
        String inputhash = "";
        
        //try catch for getiting algorithm 
        int i = -1;
        try {
        while( !E.get(++i).getAlgName().equals(type) ) ;
        } catch(IndexOutOfBoundsException e) {
            System.out.println("Error! Hash algorithm '" + type +"' not supported.");
        }

        //try catch for hashing the password user inputs
        try{
            E.get(i).init(inputpass);
            inputhash = E.get(i).hash();            
        } catch(ShiftException e){
            //System.out.println("Acess denied!");
        }

        //if hashed inputted password matches a password in the file return true
        if(inputhash.equals(correctPass)){
            return true;
        }
        return false;
   }

   /**
     This method checks if the file format is in the form of 
      user username encryptiontype password   Or
      data encryptiontype label text
      @param file - filename
    */
   public static void formatChecker(String file) {
        //Scanner to read through file
        Scanner formatcheck = null;
        try{
            formatcheck = new Scanner(new FileReader(file));
        }catch(IOException e){
            System.exit(1);
        }   

        //while loop to check format of each line
        while(formatcheck.hasNext()){
            String temp = formatcheck.nextLine();
            String[] userinfo = temp.split(" ");
            if(userinfo.length != 4){
                System.out.println("Error! File '" + file + "' improperly formatted."); 
                System.exit(1);
            }
        }   
   }
    /**
      This method checks if Access should be granted or not
      @param file - file name
      @param sc - scanner
     */
   public static void Authentication(String file, Scanner sc) throws Throwable{
        //initialize checks for username and password
        boolean usermatch = false;
        boolean passmatch = false;

        //get inputted username and password
        System.out.print("username: ");
        String username = System.console().readLine();
        System.out.print("password: ");
        char[] password = System.console().readPassword();

        //while loop that checks if username and password inputted is in the file
        while(sc.hasNext()){
            String temp = sc.nextLine();
            String[] userinfo = temp.split(" ");

            if(username.equals(userinfo[1])){
                usermatch = true;
                passmatch = correctPassword(userinfo[2], userinfo[3], password);
                break;
            }
        }
        
        //if user and password are true Access is granted and go to viewData method
        if(usermatch == true && passmatch == true){
            System.out.println("Access granted!");
            viewData(file, username, password);
        }
        else{
            System.out.println("Access denied!");
        }
    }

   
   
   
   /**
     This method allows the user to add a new user if -au is inputted initially
     @param file - file name
     @param sc - scanner
    */
   public static void newUser(String file, Scanner sc) throws Throwable{
       //initialzed arraylist of hasher types
        ArrayList<Hasher> E = new ArrayList<Hasher>();       
        E.add(new ShiftCaesar());
        E.add(new ShiftVigenere());
        E.add(new ShiftClear());   
        String hashpass = "";       
        
        //get inputted user name password and hash algorithm
        System.out.print("username: ");
        String username = System.console().readLine();
        System.out.print("password: ");
        char[] pass = System.console().readPassword();
        System.out.print("Hash algorithm: ");  
        String algorithm = System.console().readLine();

        //check if username is alreadt taken
        while(sc.hasNext()){
            String temp = sc.nextLine();
            String[] userinfo = temp.split(" ");

            if(username.equals(userinfo[1])){
                System.out.println("Error! Username '" + username + "' already in use.");
                System.exit(1);
            }            
        }
        
        
        //String p = new String(pass);

        //check if invalid symbol is used
        for(int j = 0; j < pass.length; j++){
            if((int)pass[j] < 42 || (int)pass[j] > 122){
                System.out.println("Error! Invalid symbol '" + pass[j] + "' in password.");
                System.exit(1);
            }
        }       

        // Opens an existing file, and appends to the end of it.
        PrintWriter pw = null;
        try {
        pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
        } catch (FileNotFoundException fnfe) {
        fnfe.printStackTrace();
        }
 
        int i = -1;
        try {
        while( !E.get(++i).getAlgName().equals(algorithm) ) ;
        } catch(IndexOutOfBoundsException e) {
            System.out.println("Error! Hash algorithm '" + algorithm +"' not supported.");
            System.exit(1);
        }
        
        //hash the inputted password to be added to file
        E.get(i).init(pass);
        hashpass = E.get(i).hash();         
  
        //add information to the file
        pw.printf("user " + username + ' ' + algorithm + ' ' + hashpass + "\n");
        
        //close file
        if (pw != null) pw.close();
   }

    /**
      The viewData method allows the user to get the labels and text of their own data in the file
      @param file - filename
      @param username - inputted username
      @param password - inputted password
     */
    public static void viewData(String file, String username, char[] password) throws Throwable{
        String command = "";
        Scanner readData = null;
        //gets the amount of data the user has
        int numLabels = getLines(file, username);
        //creates an array based on how many labels of data the user has
        String[] labels = getLabels(file, username, password, numLabels);
        String label = "";
        
        //try catch to see if file exists
        try{
            readData = new Scanner(new FileReader(file));
        }catch(IOException e){
        }

        //loops through program if user does not enter quit
        while(!command.equals("quit")){
           System.out.print("> ");
           command = System.console().readLine();
           String[] com = command.split(" ");
           
           //prints all labels of user if labels is typed
           if(com[0].equals("labels")){
                for(int i = 0; i < labels.length; i++){
                    String[] temp = labels[i].split(" ");
                    try{
                        String declabel = decryptLabel(temp[2], temp[3], password);
                        int firstocc = declabel.indexOf("_");                    
                        System.out.println(declabel.substring(0, firstocc));                     
                    } catch(ShiftException e){
                        System.out.println("Error! Corrupted entry '" + temp[3] + "' in vault file.");
                    }                
                }
           }
           
           //gets the text of the specific label typed after
           else if(com[0].equals("get")){
                for(int j = 0; j < labels.length; j++){
                    String[] temp = labels[j].split(" ");
                    try{
                        String declabel = decryptLabel(temp[2], temp[3], password);
                        int firstocc = declabel.indexOf("_");
                        if(com[1].equals(declabel.substring(0, firstocc))){
                            System.out.println(declabel.substring(firstocc+1, declabel.length()));
                            break;
                        }                
                    }catch(ShiftException e){
                        //System.out.println("Error! Corrupted Entry '" + temp[3] + "' in vault file.");
                    }

                }                
           }
           else if(com[0].equals("add")){
                addData(com[1], com[2], com[3], file, username, password);   
           }
           //makes sure unknown command is not printed if quit is typed
           else if(!com[0].equals("quit")){
               System.out.println("Unknown command '" + command + "'.");
           }
        }
   }

    /**
        Allows data to be added to the file
        @param shifttype - Shift
        @param label - data label
        @param data - data to be added after label
        @param file - file name
        @param user - username
        @param password - password as char array
     */
    public static void addData(String shifttype, String label, String data, String file, String user, char[] password) throws Exception{
        ArrayList<Encryptor> X = new ArrayList<Encryptor>();       
        X.add(new Caesar());
        X.add(new Vigenere());
        X.add(new Clear());     
        
        String fulldata = label + "_" + data;
        String enctext = "";
        char[] labeltemp = label.toCharArray();
        char[] texttemp = data.toCharArray();
        for(int j = 0; j < label.length(); j++){
            if((int)labeltemp[j] < 42 || (int)labeltemp[j] > 122 || (int)labeltemp[j] == 95){
                System.out.println("Error! Label '" + label + "' is invalid.");
                break;
            }
        }

        for(int j = 0; j < data.length(); j++){
            if((int)texttemp[j] < 42 || (int)texttemp[j] > 122){
                System.out.println("Error! Invalid character '" + texttemp[j] + "' in text.");
                break;
            }
        }
        int i = -1;
        try {
        while( !X.get(++i).getAlgName().equals(shifttype) ) ;
        } catch(IndexOutOfBoundsException e) {
            //System.out.println("Error! Hash algorithm '" + shifttype +"' not supported.");
            //System.exit(1);
        }

        if(shifttype.equals("clear") || shifttype.equals("caesar") || shifttype.equals("vigenere")){
            X.get(i).init(password);
            enctext = X.get(i).encrypt(fulldata); 
 
        }                
        else{
            System.out.println("Error! Encryption algorithm '" + shifttype + "' not supported.");
            return;
        }


        PrintWriter x = null;
        try {
        x = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
        } catch (FileNotFoundException fnfe) {
        fnfe.printStackTrace();
        }
 


        x.printf("data " + user + ' ' + shifttype + ' ' + enctext + "\n");
        // Do whatever you need to do

        if (x != null) x.close();        


   }

   

    /**
      Gets number of lines of data that each user has
      @param file - file name
      @param username - username
      @return int - number of lines 
     */
    public static int getLines(String file, String username){
        int numLines = 0;
        Scanner r = null;
        try{
            r = new Scanner(new FileReader(file));
        }catch(IOException e){
        }

        while(r.hasNext()){
            String temp = r.nextLine();
            String[] x = temp.split(" ");
            if(x[0].equals("data") && x[1].equals(username)){
                numLines++;
            }
            
        }
        return numLines;
   }

    /**
      Puts all of a user's label in an array for easier manipulation
      @param file - file name
      @param username - username
      @param password - password in a char array
      @param numLines - number of lines needed for users data
      @return String[] full of labels
     */
    public static String[] getLabels(String file, String username, char[] password, int numLines){
        String[] data = new String[numLines];
        Scanner r = null;
        int i = 0;
        try{
            r = new Scanner(new FileReader(file));
        }catch(IOException e){
        }

        while(r.hasNext()){
            String temp = r.nextLine();
            String[] x = temp.split(" ");
            if(x[0].equals("data") && x[1].equals(username)){                              
                data[i] = temp;
                i++;
            }
            
        }
        return data;        
   }
   
   /**
     Decrypts each label so they can be outputted to the screen
     @param shifttype - shift
     @param enctext - encrypted text
     @param password - password 
     @return string - decrypted Label
    */
   public static String decryptLabel(String shifttype, String enctext, char[] password){
        String dectext = "";
        if(shifttype.equals("clear")){
            Clear dectype = new Clear();
            dectype.init(password);
            try{
                dectext = dectype.decrypt(enctext); 
            }catch(ShiftException e){
                System.out.println("Error! Corrupted Entry '" + enctext + "' in vault file.");
            }
        }                
        else if(shifttype.equals("caesar")){
            Caesar dectype = new Caesar();
            dectype.init(password);
            dectext = dectype.decrypt(enctext);                    
        }  
        else if(shifttype.equals("vigenere")){
            Vigenere dectype = new Vigenere();
            dectype.init(password);
            try{
                dectext = dectype.decrypt(enctext); 
            }catch(ShiftException e){
                System.out.println("Error! Corrupted Entry '" + enctext + "' in vault file.");
            }
        }
        return dectext;
   }
}