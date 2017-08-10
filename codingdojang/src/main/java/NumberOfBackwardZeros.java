import java.util.Scanner;

public class NumberOfBackwardZeros {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(factorial(n));
	}

	public static int factorial(int n) {
		return n < 5 ? 0 : (n / 5) + (factorial(n / 5));
	}
}