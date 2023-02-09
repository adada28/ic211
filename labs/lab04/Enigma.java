import java.util.*;

/**
The Enigma class implements the actual Enigma cyphering using the rotors
It takes in 3 rotors and the corresponding top Characters for those constructors
and does an Enigma encryption or decryption based on the users input. 
Assitance from 3/C Michael Wieland 
@author Dada, Ayoo
 */
public class Enigma{
    private String[] codes = {"#GNUAHOVBIPWCJQXDKRYELSZFMT","#EJOTYCHMRWAFKPUZDINSXBGLQV", "#BDFHJLNPRTVXZACEGIKMOQSUWY", "#NWDKHGXZVRIFJBLMAOPSCYUTQE", "#TGOWHLIFMCSZYRVXQABUPEJKND"};
    private Rotor innerRotor,middleRotor,outerRotor;
    private String topChars;

/**
Enigma constructor creates 3 rotors: inner, middle, and outer based on 
input from user in Comms.java class
 */
    public Enigma(int r1, int r2, int r3, String topChars){
        this.topChars = topChars;
        char[] onechar = this.topChars.toCharArray();

        this.innerRotor = new Rotor(codes[r1 - 1], onechar[0]);
        this.middleRotor = new Rotor(codes[r2 - 1], onechar[1]);
        this.outerRotor = new Rotor(codes[r3 - 1], onechar[2]);
    }

/**
Encryption method that encrypts message

@param - String msg
@return - String
 */
    public String encrypt(String msg){
        char[] A = msg.toCharArray();

        for(int i = 0; i < A.length; i++){
            int temporaryInt;
            char temporaryChar;

            temporaryInt = this.innerRotor.findIndex(A[i]);
            temporaryChar = this.outerRotor.findChar(temporaryInt);
            temporaryInt = this.middleRotor.findIndex(temporaryChar);
            temporaryChar = this.outerRotor.findChar(temporaryInt);

            if((i > 0) && ((i+1) % 27 == 0)){
                middleRotor.rotate();
            }

            if((i > 0) && ((i+1) % (27*27) == 0)){
                this.outerRotor.rotate();
            }

            this.innerRotor.rotate();

            A[i] = temporaryChar;

        }
        msg = new String(A);
        return msg;
    }

/**
Decryption method that decrypts message

@param - String msg
@return - String 
 */
    public String decrypt(String msg){
        char[] A = msg.toCharArray();

        for(int i = 0; i < A.length; i++){
            int temporaryInt;
            char temporaryChar;

            temporaryInt = this.outerRotor.findIndex(A[i]);
            temporaryChar = this.middleRotor.findChar(temporaryInt);
            temporaryInt = this.outerRotor.findIndex(temporaryChar);
            temporaryChar = this.innerRotor.findChar(temporaryInt);

            if((i > 0) && ((i+1) % 27 == 0)){
                this.middleRotor.rotate();
            }

            if((i != 0) && ((i+1) % (27*27) == 0)){
                this.outerRotor.rotate();
            }

            this.innerRotor.rotate();

            A[i] = temporaryChar;

        }
        msg = new String(A);
        return msg;

    }

}