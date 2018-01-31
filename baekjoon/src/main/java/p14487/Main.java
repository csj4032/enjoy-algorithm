package p14487;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = 0;
		int sum = 0;

		for (int i = 0; i < n; i++) {
			int k = sc.nextInt();
			sum += k;
			if (max < k) max = k;
		}

		System.out.println(sum - max);
	}
}