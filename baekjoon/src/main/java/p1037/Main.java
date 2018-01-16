package p1037;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int min = 1000000;
		int max = 2;
		for (int i = 0; i < n; i++) {
			int k = sc.nextInt();
			if (k < min) min = k;
			if (k > max) max = k;
		}

		System.out.println(max * min);
	}
}
