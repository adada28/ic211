import java.util.*;

public class TestHashers{
    public static void main(String[] args) throws Throwable{
        //Create an ArrayList of all supported Hashers
        ArrayList<Hasher> E = new ArrayList<Hasher>();
        E.add(new ShiftCaesar());
        E.add(new ShiftVigenere());
        E.add(new ShiftClear());

        //Get algorithm type and password
        System.out.print("algorithm: ");
        String encalg = System.console().readLine();
        System.out.print("password : ");
        char[] password = System.console().readPassword();
       
        String strPass = new String(password);
        //checks if all strings are allowed 
        for(int j = 0; j < password.length; j++){
            if((int)password[j] < 42 || (int)password[j] > 122){
                throw new ShiftException("error " + password[j] + " not allowed in password");
            }
        }

        // Find index of encryptor (throw exception if not found)
        int i = -1;
        try {
        while( !E.get(++i).getAlgName().equals(encalg) ) ;
        } catch(IndexOutOfBoundsException e) {
        throw new NoSuchElementException("Unknown algorithm '" + encalg +"'.");
        }

        //Print Results
        System.out.println("password read : " + strPass);
        E.get(i).init(password);
        String comphash = E.get(i).hash();
        System.out.println("hash computed : " + comphash);
    }


}