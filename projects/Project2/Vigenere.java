import java.util.*;
/**
  Vigenere class that implements the Encryptor interface. 
  Does a Vigenere encrytion and just returns the message
  @author MIDN 3/C Ayoo Dada
 */
public class Vigenere implements Encryptor {
  private int n;
  private char[] k;

  /**
    Returns algorithm name
    @return String - alg name
   */  
  public String getAlgName() { return "vigenere"; }

  /**
    Init function manipulates string so it can be encrypted
    @param key - usually a password
   */  
  public void   init(char[] key) { 
    k = key;
    n = key.length;
    for(int i = 0; i < n; i++){
      if((int)key[i] < 42 || (int)key[i] > 122){
        throw new ShiftException("error " + key[i] + " not allowed in key");
      }
    }    
  }

  /**
    Encrypts the plaintext based on the encryption type
    @param plain - plaintext
    @return encrypted string
   */  
  public String encrypt(String plain) { 
    char[] ptext = plain.toCharArray();
    char[] ctext = new char[plain.length()];
    
    for(int i = 0; i < plain.length(); i++){
      char pc = ptext[i];
      char sc = k[i % n];
      char k = (char)(sc - 42);
      char p = (char)(pc - 42);
      int c = (int)(p + k) % 81;
      char cc = (char)(42 + c);
      ctext[i] = cc;
    }

    for(int i = 0; i < ctext.length; i++){
      if((int)ctext[i] < 42 || (int)ctext[i] > 122){
        throw new ShiftException("error " + ctext[i] + " not allowed in plaintext");
      }
    }  
    plain = new String(ctext);
    
    return plain; 
  }

  /**
    Decrypts the plaintext based on the encryption type
    @param cipher - ciphertext
    @return decrypted string
   */  
  public String decrypt(String cipher)
  { 
    char[] ctext = cipher.toCharArray();
    int size = cipher.length();
    char[] ptext = new char[size];

    for(int i = 0; i < cipher.length(); i++){
      char cc = ctext[i];
      char sc = k[i % n];
      char k = (char)(sc - 42);
      char c = (char)(cc - 42);     
      int p = (int)(c + (81 - k)) % 81;
      char pc = (char)(42 + p);
      ptext[i] = pc;
    }
    
    cipher = new String(ptext);
    
    return cipher; 
  }
}