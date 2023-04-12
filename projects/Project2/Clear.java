/**
  Clear class that implements the Encryptor interface. 
  Does a clear encrytion and just returns the message in its orginal form
  @author MIDN 3/C Ayoo Dada
 */
public class Clear implements Encryptor {
  /**
    Returns algorithm name
    @return String - alg name
   */
  public String getAlgName() { return "clear"; }
  
  /**
    Init function manipulates string so it can be encrypted
    @param key - usually a password
   */
  public void   init(char[] key) { 
    for(int i = 0; i < key.length; i++){
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
    for(int i = 0; i < ptext.length; i++){
      if((int)ptext[i] < 42 || (int)ptext[i] > 122){
        throw new ShiftException("error " + ptext[i] + " not allowed in plaintext");
      }
    }      
    return plain; 
  }

  /**
    Decrypts the plaintext based on the encryption type
    @param cipher - ciphertext
    @return decrypted string
   */  
  public String decrypt(String cipher){ return cipher; }
}