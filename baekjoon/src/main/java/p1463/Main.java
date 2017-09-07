package p1463;

import java.util.Scanner;

public class Main {

	static int k = 1000000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = recursive(new int[]{n}, 0);
		System.out.println(m);
		System.out.println(k);
	}

	private static int recursive(int[] n, int m) {
		return 0;
	}
}