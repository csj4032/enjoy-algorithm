import java.util.Scanner;

public class EuclidProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		solve(sc.nextInt(), sc.nextInt());
	}

	private static void solve(int n, int m) {
		int a, b;

		if (n > m) {
			a = m;
			b = n;
		} else {
			a = n;
			b = m;
		}

		int c = gcd(b, a);
		int y = 0;
		while (true) {
			if ((1 - (b / c) * y) % (a / c) == 0) {
				System.out.println(((c - (y * b)) / a) + " " + y + " " + c);
				break;
			}
			y++;
		}
	}

	private static int gcd(int a, int b) {
		int c = a > b ? a % b : b % a;
		return c == 0 ? b : gcd(b, c);
	}
}