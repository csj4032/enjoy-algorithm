package p1920;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}

		Arrays.sort(array);
		int m = sc.nextInt();

		for (int i = 0; i < m; i++) {
			if (Arrays.binarySearch(array, sc.nextInt()) < 0) {
				System.out.println(0);
			} else {
				System.out.println(1);
			}
		}
	}
}
