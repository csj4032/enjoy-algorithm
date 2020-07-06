package p15969;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int p = sc.nextInt();
			max = Math.max(max, p);
			min = Math.min(min, p);
		}
		System.out.println(max - min);
	}
}
