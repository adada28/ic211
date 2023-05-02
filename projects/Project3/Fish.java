import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;

public class Fish{
    private double goalx, goaly;
    protected double x, y, r, delta;
    private ArrayList<Fish> fishes;
    protected Random rand;

    
    public Fish(double x, double y, ArrayList<Fish> f, Random ran) {
        this.x = x; 
        this.y = y;

        //This will let us add Balls to the Arraylist shared by components in the scene
        this.fishes = b;
        rand =ran;
        r = 4 + rand.nextInt(5);
        //delta is speed of movement
        delta = 3 + rand.nextInt(8);
    }

    public Fish(double x, double y) {
        this.x = x;
        this.y = y;
        r = 4;
        delta = 6;
    }
    
    public void setGoal(double gx, double gy) {
        goalx = gx;
        goaly = gy;
    }
    public void step() {
        if (Math.sqrt(Math.pow(goaly - y, 2) + Math.pow(goalx - x, 2)) < delta){
        x = goalx;
        y = goaly;
    } else{
        double a = Math.atan2(goaly - y, goalx - x);
        x += delta * Math.cos(a);
        y += delta * Math.sin(a);
        }
    }   

    public void paint(Graphics2D g) {
        
        Graphics2D g2 = (Graphics2D)g;
        //draw the cat 
        
        g2.drawImage(img, (int)(x), (int)(y),80,80, null);
        g2.setColor(Color.RED);
        g2.draw(new Rectangle2D.Double((int)(x), (int)(y), 80, 80));
        
    }   
}