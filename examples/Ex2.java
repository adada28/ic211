import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ex2 {
  public static void main(String[] args) {
    // Create the Jframe (window) for our GUI
    JFrame f = new JFrame();

    f.setTitle("IC211 GUI Ex2");
    f.setLocation(100, 100);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create GUI components
    JLabel  l    = new JLabel("hello");
    JButton b    = new JButton("change");
    JTextField t = new JTextField(20);

    // create and add listeners for both button and
    // text field
    b.addActionListener(new ButtonClickListener(t, l));
    t.addActionListener(new TFActionListener(b));

    // Add GUI components at specified locations
    f.add(l, BorderLayout.CENTER);
    f.add(b, BorderLayout.EAST);
    f.add(t, BorderLayout.SOUTH);

    // Adjust sizes to fit everything & make visilbe
    f.pack();
    f.setVisible(true);
  }
}