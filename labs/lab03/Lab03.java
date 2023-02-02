//Help and Guidance from Michael Wieland

import java.util.*;
public class Lab03{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        int addamount = 0;

        String choice = "";

        Point one = new Point(0,0);
        Point two = new Point(0,0);
        Box B = new Box(one);

        //Loops through input and operations until done is entered
        while(!choice.equals("done")){
            choice = sc.next();

            if(choice.equals("add")){
                Point a = Point.read(sc);
                if(addamount == 0){
                    two.setX(a.getX());
                    two.setY(a.getY());
                    B.change2(a,a);
                }

                if(addamount == 1){
                    B.change2(a,two);
                    B.leastToGreatest();
                }

                B.growBy(a);
                addamount++;
            }
            
        

            else if(choice.equals("map")){
                Point a = B.mapIntoUnitSquare(Point.read(sc));
                if (a.getX() != -1){
                    System.out.println(a.toString());
                }
            }

            else if(choice.equals("box")){
                String str = B.toString();
                System.out.println(str);
            }

            else if(!(choice.equals("done"))){
                System.out.println("Error! Unknown command \"" + choice + "\"!");
            }
        }
    }

}