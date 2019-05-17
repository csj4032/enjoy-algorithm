package p5523;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = 0;
		int b = 0;
		for (int i = 0; i < n; i++) {
			int q = sc.nextInt();
			int p = sc.nextInt();
			if (q > p) {
				a++;
			} else if (q < p) {
				b++;
			}
		}
		System.out.println(a + " " + b);
	}
}