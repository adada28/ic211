import java.util.*;
/**
  ShiftCaesar class that implements the Hasher interface. 
  Shifts the initialization vectorn random amount of times then encrypts that 
  string using a Caesar algorithms. Does this 16 times then returns the hashed string
  @author MIDN 3/C Ayoo Dada
 */
public class ShiftVigenere implements Hasher{
    private String IniVector = "GO_NAVY_2018^mid";
    private char[] key;

   /**
    Returns algorithm name
    @return String - alg name
   */     
    public String getAlgName(){ return "shift+vigenere"; }
    
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
        char[] vector = IniVector.toCharArray();
        for(int i = 0; i < 16; i++){
            char c = vector[i];
            int k = (int)(c) % 16;
            vector = leftshift(vector, k); 
            Vigenere type = new Vigenere();
            type.init(key);
            String temp = new String(vector);
            String vString = type.encrypt(temp);
            vector = vString.toCharArray();
            
        }
        String finalhash = new String(vector);
        return finalhash;
    }

    /**
      Shifts string to the left based on random k value
      @param x - string as a char array
      @param k - shift amount
      @return shifted string as a char array
     */
    public char[] leftshift(char[] x, int k){

       for(int i = 0; i < k; i++){
            char first = x[0];
            for(int j = 0; j < x.length - 1; j++){
                x[j] = x[j+1];
            }
            x[x.length - 1] = first;
       } 

       return x;
    }
}