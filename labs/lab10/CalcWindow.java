import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
  * ClacWindow class extens the JFrame to 
  * make the GUI calculator windor
  * @author MIDN 3/C Ayoo Dada
  */
public class CalcWindow extends JFrame{
    //Rates options for the drop down menu
    private String[] rates = {"3.5", "3.75", "4", "4.25", "4.5", "4.75", "5", "5.25", "5.5", "5.75", "6", "6.25", "6.5", "6.75", "7", "7.25", "7.5"};
    private JComboBox<String> interestrates; 
    private JTextField t, loanamtbox, monthlypaymentbox, costbox;

    //CalcWindow Constructor for the GUI shell
    public CalcWindow(){
         // Create the Jframe (window) for our GUI
        JPanel dpanel = new JPanel(new FlowLayout());
        JPanel mid = new JPanel(new FlowLayout());
        JPanel bottom = new JPanel(new FlowLayout());
        JPanel calcbutton = new JPanel(new FlowLayout());
        this.setTitle("Dada, Ayoo - m251224");
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create GUI components
        JLabel  l    = new JLabel("loan amount");
        JLabel intrate = new JLabel("interest rate");
        JLabel m = new JLabel("monthly payment");
        JLabel monthstopay = new JLabel("months to payoff");
        JButton b    = new JButton("calculate");
        loanamtbox = new JTextField(10);
        monthlypaymentbox = new JTextField(10);
        t = new JTextField(10);
        costbox = new JTextField(10);
        interestrates = new JComboBox<String>(rates);

        ActionListener x = new ConverterActionListener(this);
        b.addActionListener(x);
        
        // Add GUI components at specified locations
        this.add(dpanel, BorderLayout.NORTH);
        this.add(mid, BorderLayout.CENTER);
        this.add(bottom, BorderLayout.SOUTH);
        this.add(calcbutton, BorderLayout.EAST);
        dpanel.add(l);
        dpanel.add(loanamtbox);
        dpanel.add(intrate);
        dpanel.add(interestrates);
        dpanel.add(m);
        dpanel.add(monthlypaymentbox);
        
        mid.add(monthstopay);
        mid.add(t);
        t.setEditable(false);

        calcbutton.add(b);


        bottom.add(new JLabel("cost"));
        bottom.add(costbox);
        costbox.setEditable(false);


        // Adjust sizes to fit everything & make visilbe
        this.pack();   
    }

    /**
      * ConverterActionListener class to take in the button click
      * @author MIDN 3/C Ayoo Dada
     */
    public class ConverterActionListener implements ActionListener{
        private CalcWindow cw;
        public ConverterActionListener(CalcWindow c){
            cw = c;
        }

        //ActionPerformed method from interface
        public void actionPerformed(ActionEvent e){
            double loanamt = Double.parseDouble(loanamtbox.getText());
            double monthlypayment = Double.parseDouble(monthlypaymentbox.getText());
            double rate = Double.parseDouble((String) interestrates.getSelectedItem());
            Calc calculateAll = new Calc(loanamt, rate,  monthlypayment);
            calculateAll.cost();

            t.setText(calculateAll.getMonths());
            costbox.setText((calculateAll.getCost()));
        }

        
    }
}