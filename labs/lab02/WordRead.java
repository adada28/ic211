import java.io.*;
import java.util.*;

public class WordRead {
    public static String[] get(String fname) {
        StringNode x = null;
        //reads the file
        Scanner sc = null;
        try {
        sc = new Scanner(new FileReader(fname));
        } catch(IOException e) {
        e.printStackTrace(); System.exit(1);
        }

        while(sc.hasNext() == true){
            ListStuff.addToBack(sc.next(), x);
            System.out.println(sc.next());
        }

        String[] wordlist = ListStuff.listToArray(x);

        for(int i = 0; i < 5; i++){
            System.out.println(wordlist[i]);
        }

        return wordlist;

    }
    public static void main(String[] args){
        WordRead.get("nouns.txt");
    }


}