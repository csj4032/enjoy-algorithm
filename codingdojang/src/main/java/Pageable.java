import java.util.Scanner;

import static java.lang.System.in;

public class Pageable {
	public static void main(String[] args) {
		Scanner sc = new Scanner(in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int p = m / n + (m % n != 0 ? 1 : 0);
		System.out.println(p);
	}
}
