import java.awt.event.*;
import javax.swing.*;
import org.json.JSONObject;
import java.util.Iterator;
import java.text.DecimalFormat;

public class CurrencyConverter extends JFrame implements ActionListener, ItemListener {
	
    // JTextField
    static JTextField t1;

    // JButton
    static JButton b;

    // label to display text
    static JLabel l1;
    static JLabel l2;
    static JLabel l3;
    
    static JComboBox c1;
    static JComboBox c2;
    
    static String oriCurrency = "usd";
    static double oriAmount;
    static String desCurrency = "cad";
    static double desAmount;
    static String currency;
    
    static String jsonResponse;
    static String[] currencies;
    static String date;
    static JSONObject eur;
    static DecimalFormat df;

    // default constructor
    public CurrencyConverter() {
    	// Attempt to fetch JSON data with fallback logic
    	jsonResponse = JsonFetcher.fetchJsonWithFallback();
        
        // If both primary and fallback URLs fail
        if (jsonResponse == null) {
            System.out.println("Both primary and fallback URLs failed to retrieve data.");
        } else {
            // If successful, print the JSON response
            System.out.println("Received JSON data successfully!");
        }
        
        JSONObject jsonObject = new JSONObject(jsonResponse);
        date = jsonObject.getString("date");
        eur = jsonObject.getJSONObject("eur");
        
        //******
        // Use an iterator to get all keys (currency names)
        Iterator<String> keys = eur.keys();
        
        // Create a list to store the currency names
        currencies = new String[eur.length()];
        int i = 0;

        // Iterate over the keys and store them in the array
        while (keys.hasNext()) {
            String key = keys.next();
            currencies[i] = key;  // Add currency name to array
            i++;
        }
        //******
	}

    // if the button is pressed
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("convert")) {
            // set the text of the label to the text of the field
        	
        	oriAmount = Double.parseDouble(t1.getText());
        	desAmount = currConverter();
        	l2.setText(Double.toString(desAmount));
        	l3.setText("Currency on " + date + " is " + oriCurrency + "/" + desCurrency + ": " + currency);
        }
        
    }
    
    public void itemStateChanged(ItemEvent e)
    {
        // if the state combobox is changed
        if (e.getSource() == c1) {
        	oriCurrency = (String) c1.getSelectedItem();
        	currency = df.format(1 / eur.getDouble(oriCurrency) * eur.getDouble(desCurrency));
        	//System.out.println("Source currency changed to: " + oriCurrency);
        } else if (e.getSource() == c2) {
        	desCurrency = (String) c2.getSelectedItem();
        	currency = df.format(1 / eur.getDouble(oriCurrency) * eur.getDouble(desCurrency));
        	//System.out.println("Destination currency changed to: " + desCurrency);
        }
    }
    
    public double currConverter() {
    	df = new DecimalFormat("####0.00");
    	return Double.valueOf(df.format(oriAmount / eur.getDouble(oriCurrency) * eur.getDouble(desCurrency)));
    }	

}