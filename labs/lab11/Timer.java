import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Timer extends JFrame{
    private JLabel lab;
    private JTextField t;
    public Timer(){
        JPanel x = new JPanel(new FlowLayout());
        this.setTitle("Lab 11 - Timer");
        this.setLocation(100, 100); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lab = new JLabel("DONE");
        lab.setPreferredSize(new Dimension(60,15));
        lab.setForeground(Color.RED); 
        t = new JTextField(10);
        t.setText("10");
        JButton b    = new JButton("countdown");

        ActionListener a = new ConverterActionListener(this, lab);
        b.addActionListener(a);

        this.add(x, BorderLayout.NORTH);
        x.add(lab);
        x.add(t); 
        x.add(b);

        this.pack();
           
    }
    
    public class ConverterActionListener implements ActionListener{
        private Timer cw;
        private Thread th;
        private boolean b;
        private int timeleft;
        private JLabel num;
        public ConverterActionListener(Timer c, JLabel l){
            cw = c;
            num = l;
            this.b = true;
        }

        //ActionPerformed method from interface
        public void actionPerformed(ActionEvent e){
            try{
                timeleft = Integer.valueOf(t.getText());
            } catch(NumberFormatException f){
                num.setText("ERROR");
                return;
            }
            
           // Count countdown = new Count(timeleft, lab);
            if(this.b == true || !th.isAlive()){
                this.th = new Count(timeleft, num);
                th.start();
                this.b = false;
            }
        }

        
    }
}