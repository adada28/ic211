import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalcWindow extends JFrame{
    private String[] rates = {"3.5", "3.75", "4", "4.25", "4.5", "4.75", "5", "5.25"};
    private JComboBox<String> interestrates; 
    private JTextField t, loanamtbox, monthlypaymentbox, costbox;


    public CalcWindow(){
         // Create the Jframe (window) for our GUI
        //JFrame f = new JFrame();
        JPanel dpanel = new JPanel(new FlowLayout());
        JPanel mid = new JPanel(new FlowLayout());
        JPanel bottom = new JPanel(new FlowLayout());
        JPanel calcbutton = new JPanel(new FlowLayout());
        this.setTitle("Dada, Ayoo - m251224");
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create GUI components
        JLabel  l    = new JLabel("loan amount");
        JLabel intrate = new JLabel("interest rate");
        JLabel m = new JLabel("monthly payment");
        JLabel monthstopay = new JLabel("months to payoff");
        JButton b    = new JButton("calculate");
        loanamtbox = new JTextField(10);
        monthlypaymentbox = new JTextField(10);
        t = new JTextField(10);
        costbox = new JTextField(10);
        interestrates = new JComboBox<String>(rates);

        ActionListener x = new ConverterActionListener(this);
        b.addActionListener(x);
        
        // Add GUI components at specified locations
        this.add(dpanel, BorderLayout.NORTH);
        this.add(mid, BorderLayout.CENTER);
        this.add(bottom, BorderLayout.SOUTH);
        this.add(calcbutton, BorderLayout.EAST);
        dpanel.add(l);
        dpanel.add(loanamtbox);
        dpanel.add(intrate);
        dpanel.add(interestrates);
        dpanel.add(m);
        dpanel.add(monthlypaymentbox);
        
        mid.add(monthstopay);
        mid.add(t);
        t.setEditable(false);

        calcbutton.add(b);


        bottom.add(new JLabel("cost"));
        bottom.add(costbox);
        costbox.setEditable(false);

        
        //f.add(intrate, BorderLayout.CENTER);

        // Adjust sizes to fit everything & make visilbe
        this.pack();   
    }

    public class ConverterActionListener implements ActionListener{
        
    }
}