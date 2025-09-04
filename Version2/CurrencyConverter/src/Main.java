import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // create a new frame to store text field and button
        JFrame f = new JFrame("textfield");

        // create a new button
        CurrencyConverter.b = new JButton("convert");
        //CurrencyConverter.b.setBounds(300,200,60,15);
        
        String str[] = {"USD","CAD","EUR","CNY","AUD"};
        CurrencyConverter.c1 = new JComboBox(str);
        CurrencyConverter.c2 = new JComboBox(str);

        // create an object of the Text class
        CurrencyConverter cc = new CurrencyConverter();

        // addActionListener to button
        CurrencyConverter.b.addActionListener(cc);
        
        
        CurrencyConverter.l1 = new JLabel("=>");
        CurrencyConverter.l2 = new JLabel("0");

        // create a object of JTextField with 16 columns
        CurrencyConverter.t1 = new JTextField(9);
        
       
        CurrencyConverter.c1.addItemListener(cc);
        CurrencyConverter.c2.addItemListener(cc);

        // create a panel to add buttons and textfield
        JPanel p = new JPanel();

        // add buttons and textfield to panel
        p.add(CurrencyConverter.c1);
        p.add(CurrencyConverter.t1);
        p.add(CurrencyConverter.l1);
        p.add(CurrencyConverter.c2);
        p.add(CurrencyConverter.l2);
        p.add(CurrencyConverter.b);

        // add panel to frame
        f.add(p);
        
        //f.setLayout(null); 
        // set the size of frame
        f.setBounds(450,200,400,300);
        f.setTitle("Currency Converter");
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // show the frame
        f.setVisible(true);
    }
}
