package p11653;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = 2;

		while (n > 1) {
			if (n % k == 0) {
				System.out.println(k);
				n = n / k;
			} else {
				k = k + 1;
			}
		}
	}
}