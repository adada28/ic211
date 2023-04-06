import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class lab10 {
  public static void main(String[] args) {
    // Create the Jframe (window) for our GUI
    JFrame f = new JFrame();
    JPanel dpanel = new JPanel(new FlowLayout());
    f.setTitle("Dada, Ayoo - m251224");
    f.setLocation(100, 100);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create GUI components
    JLabel  l    = new JLabel("loan amount");
    JLabel intrate = new JLabel("interest rate");
    JButton b    = new JButton("change");
    JTextField t = new JTextField(20);

    // Add GUI components at specified locations
    f.add(l, BorderLayout.WEST);
    dpanel.add(new JLabel("interest rate"));
    f.add(t, BorderLayout.SOUTH);

    // Adjust sizes to fit everything & make visilbe
    f.pack();
    f.setVisible(true);
  }
}