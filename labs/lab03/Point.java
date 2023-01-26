import java.util.*;
public class Point{
    public double x,y;

    public Point(double px, double py){
        x = px;
        y = py;
    }

    public static Point read(Scanner sc){
        double x = sc.nextDouble();
        double y = sc.nextDouble();

        Point A = new Point(x,y);
        return A;

    }

    public String toString(){
        return p.x + " " + p.y; 
    }
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String choice = in.next();
        
        if(choice == "add"){
            Point p1 = read(in);
            p1.toString();
            System.out.println();
        }

    }
}