package p5596;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		for (int i = 0; i < 2; i++) {
			int sum = 0;
			for (int j = 0; j < 4; j++) {
				sum += sc.nextInt();
			}
			if (max < sum) max = sum;
		}
		System.out.println(max);
	}
}