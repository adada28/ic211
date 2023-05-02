import java.awt.*;
import javax.swing.*;

public class AquariumMain {
  public static void main(String[] args) {
    JFrame f     = new JFrame();
    JComponent c = new Aquariumarea();
    Random random = new Random();

    ArrayList<Fish> life = new ArrayList<Fishs>();
    
    Panel p = new Panel(life, random);

    f.add(c);
    f.add(p, BorderLayout.NORTH);


    f.pack();
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
