import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Foo extends Thread {
  private JLabel label;

  public Foo(JLabel l) {
    this.label = l;
  }

  public void run() {
    CChange.changeColor(label);
  }
}