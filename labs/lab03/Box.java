import java.util.*;
public class Box{
    public Point min, max;
    public Box(Point p1){
        min = p1;
        max = p1;

        System.out.println(this);
    }

    public String toString(){
        return min.x + " < x < " + max.x + ", " + min.y + " < y < " + max.y;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        Point test = new Point(4,5);
        Box a = new Box(test);



    }



}