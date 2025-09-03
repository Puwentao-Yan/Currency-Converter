import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input: ");
		String input = scanner.nextLine();
		try {
			CurrencyConverter cc = new CurrencyConverter(input);
			DecimalFormat f = new DecimalFormat("##.00");
			double desAmount = cc.currConverter();
			System.out.println(f.format(desAmount));
		} catch (Exception e) {
			System.out.println("");
		}
	}
}
