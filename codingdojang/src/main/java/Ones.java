import java.util.Arrays;
import java.util.Scanner;

public class Ones {

	public static void main(String[] args) {

		long n = new Scanner(System.in).nextLong();
		long c = 0;

		while (true) {
			long nc = n * c;
			String[] snc = String.valueOf(nc).split("");
			if (Arrays.asList(snc).stream().allMatch(i -> i.equals("1"))) {
				System.out.println(snc.length);
				break;
			}
			c++;
		}
	}
}