import java.util.Scanner;
import java.util.stream.IntStream;

public class Fibonacci {

	public static void main(String[] args) {
		IntStream.range(0, new Scanner(System.in).nextInt()).forEach(i -> System.out.println(fibonacci(i)));
	}

	private static int fibonacci(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}