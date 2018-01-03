package p2455;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer max = 0;
		Integer sum = 0;
		for (int i = 0; i < 4; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			sum = sum - a + b;
			if (sum > max) max = sum;
		}
		System.out.println(max);
	}
}