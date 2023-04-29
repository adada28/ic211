import javax.swing.*;
import java.awt.event.*;

public class Mystery implements ActionListener {
  private JLabel label;
  private Thread t;
  private boolean b; 
  public Mystery(JLabel label) {
    this.label = label;
    this.b = true;
  }

  public void actionPerformed(ActionEvent e) {
    //CChange.changeColor(label);
    if(this.b == true || !t.isAlive()){
        this.t = new Foo(label);
        t.start();
        this.b = false;
    }
  }
}