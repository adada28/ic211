import java.util.*;
public class HW3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("How many mids? ");
        int midnum = sc.nextInt();
        Mid[] info = new Mid[midnum];
        
        for(int i = 0; i < midnum; i++){
            Mid midinfo = createMid(sc);
            info[i] = midinfo;
        }

        System.out.print("What company would you like to print out? ");
        int companychoice = sc.nextInt();

        for(int j = 0; j < midnum; j++){
            if(info[j].company == companychoice)
                printMid(info[j]);
        }

    }

    public static Mid createMid(Scanner in){
        Mid x = new Mid();
        System.out.print("Alpha? ");
        String alphanum = in.next();
        x.alpha = alphanum;
        System.out.print("First name? ");
        String fname = in.next();
        x.firstName = fname;
        System.out.print("Last name? ");
        String lname = in.next();
        x.lastName = lname;
        System.out.print("Company? ");
        int companynum = in.nextInt();
        x.company = companynum;

        return x;
    }

    public static void printMid(Mid x){
        System.out.println(x.alpha + " " + x.lastName + " " + x.firstName + " " + x.company);
    }

}