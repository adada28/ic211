import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Panel extends JPanel{
    private String[] fish = {"Plankton", "Clownfish", "Tuna", "Shark"};
    private String[] advance = {"Clownfish Speed", "Clownfish Stravation Threshold", "Tuna Speed", "Tuna Starvation Threshold", "Shark Speed", "Shark Starvation Threshold"};
    private JComboBox<String> fishtypes, advcontrols;
    private ArrayList<Fish> fishlist;

    public Panel(ArrayList<Fish> f, Random rand){
        fishlist = f;
        this.setLayout(new FlowLayout());
        JButton start = new JButton("Start");
        this.add(start);
        fishtypes = new JComboBox<String>(fish);
        this.add(fishtypes);
        JButton addbutton = new JButton("Add");
        this.add(addbutton);
        advcontrols = new JComboBox<String>(advcontrols);
        this.add(advcontrols); 
         
    }
}