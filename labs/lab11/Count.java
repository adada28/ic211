import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Count extends Thread{
    private int time;
    private JLabel label;
    public Count(int t, JLabel l){
        time = t;
        label = l;
    }

    public void run(){
        int secs = 0;
        try{
            secs = time;
        } catch(NumberFormatException e){
            label.setText("ERROR");
            return;
        }

        if(secs < 0){
            label.setText("ERROR");
            return;
        }

        for(int i = secs; i > 0; i--){
            label.setText(String.valueOf(i));
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        label.setText("DONE");
    }
}