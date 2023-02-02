import java.util.*;
public class Point{
    private double x,y;

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }
    /*
    public void setminY(double y){
        this.y = y; 
    }

    public void setminX(double x){
        this.x = x; 
    }
*/
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
        return this.x + " " + this.y; 
    }
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String choice = in.next();
        
        if(choice.equals("add")){
            Point p1 = read(in);
            System.out.println(p1);
        }

    }
}