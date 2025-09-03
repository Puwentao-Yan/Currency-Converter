
public class CurrencyConverter {
	private String input;
	private double oriAmount;
	private String oriCurrency;
	private String desCurrency;
	
	public CurrencyConverter(String input) {
		this.input = input.toUpperCase();
		try {
			stringOp(this.input);
		} catch (Exception e) {
			System.out.println("Incorrect input format. Format example: 100 USD to EUR");
		}
		
	}
	
	public void stringOp(String input) {
		//String test = "100 USD to EUR";
		String[] inputArray = input.split("[ ]");
		this.oriAmount = Double.parseDouble(inputArray[0]);
		this.oriCurrency = inputArray[1];
		this.desCurrency = inputArray[3];
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
