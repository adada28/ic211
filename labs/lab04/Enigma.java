import java.util.*;

public class Enigma{
    private String[] codes = {"#GNUAHOVBIPWCJQXDKRYELSZFMT","#EJOTYCHMRWAFKPUZDINSXBGLQV", "#BDFHJLNPRTVXZACEGIKMOQSUWY", "#NWDKHGXZVRIFJBLMAOPSCYUTQE", "#TGOWHLIFMCSZYRVXQABUPEJKND"};
    private Rotor innerRotor,middleRotor,outerRotor;
    private String topChars;

    public Enigma(int r1, int r2, int r3, String topChars){
        this.topChars = topChars;
        char[] onechar = this.topChars.toCharArray();

        this.innerRotor = new Rotor(codes[r1 - 1], onechar[0]);
        this.middleRotor = new Rotor(codes[r2 - 1], onechar[1]);
        this.outerRotor = new Rotor(codes[r3 - 1], onechar[2]);
    }

    public String encrypt(String msg){
        char[] A = msg.toCharArray();

        for(int i = 0; i < A.length; i++){
            int temporaryInt;
            char temporaryChar;

            temporaryInt = this.innerRotor.findIndex(A[i]);
            temporaryChar = this.outerRotor.findChar(temporaryInt);
            temporaryInt = this.middleRotor.findIndex(temporaryChar);
            temporaryChar = this.outerRotor.findChar(nextchar);

            if((i > 0) && ((i+1) % 27 == 0)){
                middleRotor.rotate();
            }

            if

        }

    }

    public String decrypt(String msg){

    }

    public Static void main(String[] args){

    }
    

}