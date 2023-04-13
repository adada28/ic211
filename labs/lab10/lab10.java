import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class lab10 {

  public static void main(String[] args) {
  String[] rates = {"3.5", "3.75", "4", "4.25", "4.5", "4.75", "5", "5.25"};
  JComboBox<String> interestrates;
    // Create the Jframe (window) for our GUI
    JFrame f = new JFrame();
    JPanel dpanel = new JPanel(new FlowLayout());
    JPanel mid = new JPanel(new FlowLayout());
    JPanel bottom = new JPanel(new FlowLayout());
    f.setTitle("Dada, Ayoo - m251224");
    f.setLocation(100, 100);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create GUI components
    JLabel  l    = new JLabel("loan amount");
    JLabel intrate = new JLabel("interest rate");
    JLabel m = new JLabel("monthly payment");
    JLabel monthstopay = new JLabel("months to payoff");
    JButton b    = new JButton("calculate");
    JTextField loanamtbox = new JTextField(20);
    JTextField monthlypaymentbox = new JTextField(20);
    JTextField t = new JTextField(20);
    JTextField costbox = new JTextField(20);
    interestrates = new JComboBox<String>(rates);

    // Add GUI components at specified locations
    f.add(dpanel, BorderLayout.NORTH);
    f.add(mid, BorderLayout.CENTER);
    f.add(bottom, BorderLayout.SOUTH);
    dpanel.add(l);
    dpanel.add(loanamtbox);
    dpanel.add(intrate);
    dpanel.add(interestrates);
    dpanel.add(m);
    dpanel.add(monthlypaymentbox);
    
    mid.add(monthstopay);
    mid.add(t);
    mid.add(b, BorderLayout.EAST);

    bottom.add(new JLabel("cost"));
    bottom.add(costbox);


    
    //f.add(intrate, BorderLayout.CENTER);

    // Adjust sizes to fit everything & make visilbe
    f.pack();
    f.setVisible(true);
  }
}