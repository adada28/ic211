//Attended MGSP on 02/02/23 with MIDN 2/C Clancy who guided my methodology
//Guidance from Michael Wieland who is in my company
import java.util.*;
public class Box{
    private Point min, max;

    //Initiaze Origin Points that will change
    private Point A = new Point (0,0);
    private Point B = new Point (0,0);

    //Box with one point
    public Box(Point p1) {
        this.A = p1;
        this.B = p1;
    }

    //Box with 2 point
    public Box(Point a, Point b){
        this.A = a;
        this.B = b;
        
    }

    //Map operator function
    public Point mapIntoUnitSquare(Point P){
        if (P.getX() >= this.A.getX() && P.getX() <= this.B.getX() && P.getY() >= this.A.getY() && P.getY() <= this.B.getY()){
                double width = this.B.getX() - this.A.getX();
                double height = this.B.getY() - this.A.getY();
                double newX = ((P.getX() - this.A.getX()) / width);
                double newY = ((P.getY() - this.A.getY()) / height);


                Point map = new Point(newX,newY);

                return map; 
        }
        else{
            System.out.println("error");
            Point g = new Point(-1,-1);
            return g;
        }

        
    }
    //Takes in new point to compare points to help least to greatest
    public void change2(Point x, Point y){
        this.A = x;
        this.B = y;
    }

    //Puts two points in order from least to greatest to help set bounds for toString()
    //A is min point, B is max point
    public void leastToGreatest(){
        if (this.A.getX() > this.B.getX()){
            double temp = this.A.getX();
            this.A.setX(this.B.getX());
            this.B.setX(temp);
        }
        if (this.A.getY() > this.B.getY()){
            double temp2 = this.A.getY();
            this.A.setY(this.B.getY());
            this.B.setY(temp2);
        }
    }

    public String toString(){
        return this.A.getX() + " < x < " + this.B.getX() + ", " + this.A.getY() + " < y < " + this.B.getY();
    }

    //Increases box as new point is added
    public void growBy(Point p){
        //Box t = new Box();
        if(p.getX() < this.A.getX()){
            this.A.setX(p.getX());
        }
        else if(p.getX() > this.B.getX()){
            this.B.setX(p.getX());
        }

        if(p.getY() < this.A.getY()){
            this.A.setY(p.getY());
        }

        else if(p.getY() > this.B.getY()){
            this.B.setY(p.getY());
        }
    }

    public static void main(String[] args){
        Point a = new Point(1,2);
        Point b = new Point(3,4);
        Box t = new Box(a,b);

        t.growBy(a);
        t.growBy(b);

        String s = t.toString();
        System.out.println(s);

        
    }

}