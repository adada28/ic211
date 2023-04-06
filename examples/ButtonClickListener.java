import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ButtonClickListener implements ActionListener {
  JTextField tf;
  JLabel     lb;
  public ButtonClickListener(JTextField t,
                             JLabel     l) {
    tf = t;
    lb = l;
  }

  public void actionPerformed(ActionEvent e) {
    if (!tf.getText().equals("")) {
      lb.setText(tf.getText());
    }
    tf.setText("");
  }
}