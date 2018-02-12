package p2587;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] m = new int[5];
		int t = 0;
		for (int i = 0; i < 5; i++) {
			int k = sc.nextInt();
			m[i] = k;
			t += k;
		}

		Arrays.sort(m);
		System.out.println(t / 5);
		System.out.println(m[2]);
	}
}
