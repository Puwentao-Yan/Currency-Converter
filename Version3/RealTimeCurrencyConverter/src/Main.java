import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

import org.json.JSONObject;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
    	// create a new frame to store text field and button
        JFrame f = new JFrame("textfield");
        
        CurrencyConverter cc = new CurrencyConverter();
        // create a new button
        CurrencyConverter.b = new JButton("convert");
        
        CurrencyConverter.c1 = new JComboBox(CurrencyConverter.currencies);
        CurrencyConverter.c2 = new JComboBox(CurrencyConverter.currencies);
        
        CurrencyConverter.c1.setSelectedIndex(243);
        CurrencyConverter.c2.setSelectedIndex(297);
        
        CurrencyConverter.c1.addItemListener(cc);
        CurrencyConverter.c2.addItemListener(cc);
        
        CurrencyConverter.c1.setEditable(true);
        CurrencyConverter.c2.setEditable(true);
        
        CurrencyConverter.b.addActionListener(cc);
        
        
        CurrencyConverter.l1 = new JLabel("To");
        CurrencyConverter.l2 = new JLabel("0");
        CurrencyConverter.df = new DecimalFormat("####0.00");
        CurrencyConverter.currency = CurrencyConverter.df.format(1 / CurrencyConverter.eur.getDouble(CurrencyConverter.oriCurrency) * CurrencyConverter.eur.getDouble(CurrencyConverter.desCurrency));
        CurrencyConverter.l3 = new JLabel("Currency on " + CurrencyConverter.date + " is " + CurrencyConverter.oriCurrency + "/" + CurrencyConverter.desCurrency + ": " + CurrencyConverter.currency);
        
        // Set background for l2 and make it opaque like a JTextField
        CurrencyConverter.l2.setBackground(Color.WHITE);
        CurrencyConverter.l2.setOpaque(true);  // Make sure background is visible
        CurrencyConverter.l2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));  // Line border similar to JTextField
        
        // Set some padding for l2
        CurrencyConverter.l2.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        // create a object of JTextField with 16 columns
        CurrencyConverter.t1 = new JTextField(9);

        
        
       
        f.setTitle("Currency Converter");
        f.setLayout(new BorderLayout());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(450,200,400,300);

        
        
        // create a panel to add buttons and textfield
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        
        // add buttons and textfield to panel
        p.add(CurrencyConverter.c1);
        p.add(CurrencyConverter.t1);
        p.add(CurrencyConverter.l1);
        p.add(CurrencyConverter.c2);
        p.add(CurrencyConverter.l2);
        p.add(CurrencyConverter.b);
        p.add(CurrencyConverter.l3);
        
        // add panel to frame
        f.add(p, BorderLayout.CENTER);
        f.setResizable(false);
        // show the frame
        f.setVisible(true);
    }
}
