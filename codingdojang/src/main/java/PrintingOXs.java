import java.util.Scanner;
import java.util.stream.IntStream;

import static java.lang.System.in;

public class PrintingOXs {

	public static void main(String[] args) {
		int n = new Scanner(in).nextInt();
		IntStream.range(0, n).forEach(i -> IntStream.range(0, n).forEach(j -> {
					System.out.print(j + i >= (n - 1) ? "X" : "O");
					if (j == n - 1) System.out.println("");
				})
		);
	}
}
