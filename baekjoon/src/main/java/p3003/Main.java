package p3003;

import java.util.Scanner;

public class Main {

	static int[] sets = new int[]{1, 1, 2, 2, 2, 8};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 6; i++) {
			System.out.print(sets[i] - sc.nextInt() + " ");
		}
	}
}