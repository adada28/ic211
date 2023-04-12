import javax.swing.*;

public class Ex1 {

  public static void main(String[] args) {

    JFrame[] F = new JFrame[5];

    for( int i = 0; i < 5; i++ ) {
      JFrame f = new JFrame();
      f.setTitle("IC211 GUI Ex1 " + i);
      f.setSize(300, 400);
      f.setLocation(100 + 10 * i, 100 + 10 * i);

     // f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      F[i] = f;
    }

    System.out.print("Enter x to continue: ");
    System.console().readLine();

    for( int i = 0; i < 5; i++ ) {
      F[i].setVisible(true);
    }
  }
}