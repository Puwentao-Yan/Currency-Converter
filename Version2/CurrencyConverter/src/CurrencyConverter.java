import java.awt.event.*;
import javax.swing.*;

public class CurrencyConverter extends JFrame implements ActionListener, ItemListener {
	
    // JTextField
    static JTextField t1;

    // JButton
    static JButton b;

    // label to display text
    static JLabel l1;
    static JLabel l2;
    
    static JComboBox c1;
    static JComboBox c2;
    
    static String oriCurrency = "USD";
    static double oriAmount;
    static String desCurrency = "USD";
    static double desAmount;

    // default constructor
    public CurrencyConverter() {
		
	}

    // if the button is pressed
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("convert")) {
            // set the text of the label to the text of the field
        	
        	oriAmount = Double.parseDouble(t1.getText());
        	desAmount = currConverter();
        	l2.setText(Double.toString(CurrencyConverter.desAmount));
        }
        
    }
    
    public void itemStateChanged(ItemEvent e)
    {
        // if the state combobox is changed
        if (e.getSource() == c1) {
        	oriCurrency = (String) c1.getSelectedItem();
        	//System.out.println("Source currency changed to: " + oriCurrency);
        } else if (e.getSource() == c2) {
        	desCurrency = (String) c2.getSelectedItem();
        	//System.out.println("Destination currency changed to: " + desCurrency);
        }
    }
    
    public double currConverter() {
		switch(oriCurrency) 
		{
			case "USD":
				switch(desCurrency) 
				{
					case "USD":
						return oriAmount;
					case "CAD":
						return (oriAmount * 1.37);
					case "EUR":
						return (oriAmount * 0.86);
					case "CNY":
						return (oriAmount * 7.13);
					case "AUD":
						return (oriAmount * 1.57);
				}
				break;
			case "CAD":
				switch(desCurrency) 
				{
					case "USD":
						return (oriAmount * 0.73);
					case "CAD":
						return oriAmount;
					case "EUR":
						return (oriAmount * 0.62);
					case "CNY":
						return (oriAmount * 5.19);
					case "AUD":
						return (oriAmount * 1.11);
				}
				break;
			case "EUR":
				switch(desCurrency) 
				{
					case "USD":
						return (oriAmount * 1.17);
					case "CAD":
						return (oriAmount * 1.61);
					case "EUR":
						return oriAmount;
					case "CNY":
						return (oriAmount * 8.33);
					case "AUD":
						return (oriAmount * 1.79);
				}
				break;
			case "CNY":
				switch(desCurrency) 
				{
					case "USD":
						return (oriAmount * 0.14);
					case "CAD":
						return (oriAmount * 0.19);
					case "EUR":
						return (oriAmount * 0.12);
					case "CNY":
						return oriAmount;
					case "AUD":
						return (oriAmount * 0.21);
				}
				break;
			case "AUD":
				switch(desCurrency) 
				{
					case "USD":
						return (oriAmount * 0.65);
					case "CAD":
						return (oriAmount * 0.90);
					case "EUR":
						return (oriAmount * 0.56);
					case "CNY":
						return (oriAmount * 4.66);
					case "AUD":
						return oriAmount;
				}
				break;
		}
		System.out.println("Input currency type currently not supported.\nPlease reset currency type with setCurrency() method.");
		return -1;
	}

}
