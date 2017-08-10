import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InvestmentInStocks {

	public static void main(String[] args) throws FileNotFoundException {
		String path = InvestmentInStocks.class.getResource("").getPath();
		Scanner sc = new Scanner(new File(path + "InvestmentInStocks.txt"));
		Double amount = sc.nextDouble();
		Integer days = sc.nextInt();
		Double result = amount;

		for (int i = 0; i < days; i++) {
			result = result + (result * sc.nextInt() / 100);
		}

		System.out.println(Math.round(amount - result));
		System.out.println(amount < result ? "good" : "bad");
	}
}