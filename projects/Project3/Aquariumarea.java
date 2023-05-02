import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

public class Aquariumarea extends JComponent implements Runnable{
  private 
  private BufferedImage img = null;
  public Aquariumarea() {
    super();
    setPreferredSize(new Dimension(500, 250));
        
    try {
      img = ImageIO.read(new File("myaquarium.jpg"));
    } catch (IOException e) {}
    
  }

  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;

    // This voodoo makes the output prettier
    g2.setRenderingHint(
      RenderingHints.KEY_ANTIALIASING,
      RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setRenderingHint(
      RenderingHints.KEY_RENDERING,
      RenderingHints.VALUE_RENDER_QUALITY);

 

    // Drawing an image
    g2.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);

    // Playing with transforms
    g2.setStroke(new BasicStroke(1));
    AffineTransform savedTf = g2.getTransform();
    g2.translate(300, 300);

    AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
    tx.translate(-img.getWidth(), 0);
    AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
    img = op.filter(img, null);    

/*
    for (int i = 0; i < 24; i++) {
      g2.rotate(Math.PI / 24);
      g2.draw(new Rectangle2D.Double(0, 0, 60, 60));
    } 
    g2.setTransform(savedTf);
  */
  }
}
