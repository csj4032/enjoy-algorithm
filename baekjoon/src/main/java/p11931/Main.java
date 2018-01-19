package p11931;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] m = new int[n];
		for (int i = 0; i < n; i++) {
			m[i] = sc.nextInt();
		}
		Arrays.sort(m);
		for (int i = n-1; i >= 0; i--) {
			System.out.println(m[i]);
		}
	}
}