import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TFActionListener implements ActionListener {
  private JButton b;
  public TFActionListener(JButton b) {
    this.b = b;
  }

  public void actionPerformed(ActionEvent e) {
    b.doClick(); // "fakes" a button click on b
  }
}