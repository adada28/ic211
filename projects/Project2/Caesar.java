import java.util.*;
/**
  Caesar class that implements the Encryptor interface. 
  Does a Caesar encrytion and just returns the message
  @author MIDN 3/C Ayoo Dada
 */
public class Caesar implements Encryptor {
  //initial shift number
  private int shift = 18;
  
  /**
    Returns algorithm name
    @return String - alg name
   */
  public String getAlgName() { return "caesar"; }
  
  /**
    Init function manipulates string so it can be encrypted
    @param key - usually a password
   */  
  public void   init(char[] key) {  
    for(int i = 0; i < key.length; i++){
      if((int)key[i] < 42 || (int)key[i] > 122){
        throw new ShiftException("error " + key[i] + " not allowed in key");
      }
      shift = shift + (int)key[i]-42;
    }
    shift = (shift % 81) + 42;
  }
  
  /**
    Encrypts the plaintext based on the encryption type
    @param plain - plaintext
    @return String
   */  
  public String encrypt(String plain) { 
    char[] ptext = plain.toCharArray();
    for(int i = 0; i < plain.length(); i++){
      char k = (char)(shift - 42); 
      char p = (char)(ptext[i] - 42);
      int c = (int)(p + k) % 81;
      char cc = (char)(42 + c); 
      ptext[i] = cc;      
    }
    for(int j = 0; j < ptext.length; j++){
      if((int)ptext[j] < 42 || (int)ptext[j] > 122){
        throw new ShiftException("error " + ptext[j] + " not allowed in plaintext");
      }
    }      
    plain = new String(ptext);
    return plain; 
  }
  
  /**
    Decrypts the plaintext based on the encryption type
    @param cipher - ciphertext
    @return decrypted string
   */
  public String decrypt(String cipher){ 
    char[] ctext = cipher.toCharArray();
    for(int j = 0; j < ctext.length; j++){
      if((int)ctext[j] < 42 || (int)ctext[j] > 122){
        throw new ShiftException("error " + ctext[j] + " not allowed in ciphertext");
      }
    }
    for(int i = 0; i < cipher.length(); i++){
      char k = (char)(shift - 42); 
      char c = (char)(ctext[i] - 42);
      int p = (int)(c + (81 - k)) % 81;
      char pc = (char)(42 + p); 
      ctext[i] = pc;      
    }
    cipher = new String(ctext);    
    return cipher; 
  }
}