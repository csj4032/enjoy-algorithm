package aizu;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumProfit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			var r = sc.nextInt();
			array[i] = r;
		}
		System.out.println(Arrays.toString(array));
	}
}