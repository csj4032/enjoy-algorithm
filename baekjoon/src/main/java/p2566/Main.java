package p2566;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int maxRow = 0;
		int maxCol = 0;
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				int n = sc.nextInt();
				if (max < n) {
					max = n;
					maxRow = i;
					maxCol = j;
				}
			}
		}

		System.out.println(max);
		System.out.println(maxRow + " " + maxCol);
	}
}