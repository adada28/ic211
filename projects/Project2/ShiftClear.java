import java.util.*;
/**
  ShiftClear class that implements the Hasher interface. 
  Does a Clear encrytion and adds 'x' to end of string to make it 16 characters
  just returns the message
  @author MIDN 3/C Ayoo Dada
 */
public class ShiftClear implements Hasher{
    private char[] key;
  /**
    Returns algorithm name
    @return String - alg name
   */      
    public String getAlgName(){ return "clear"; }
    
  /**
    Init function manipulates string so it can be encrypted
    @param password - usually a password
   */    
    public void init(char[] password){
        key = password;
        for(int i = 0; i < password.length; i++){
            if((int)password[i] < 42 || (int)password[i] > 122){
                throw new ShiftException("error " + password[i] + " not allowed in key");
            }
        }        
    }

    /**
      Hashes string 
      @return hased string 
     */
    public String hash(){
        char[] finalhash = new char[16];
        for(int i = 0; i < finalhash.length; i++){
            if(i+1 > key.length){
                finalhash[i] = 'x';
            }
            else{
                finalhash[i] = key[i];   
            }
        }
        String finhash = new String(finalhash);
        return finhash;
    }

}