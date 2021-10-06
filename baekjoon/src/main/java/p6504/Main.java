package p6504;

import java.util.Scanner;

public class Main {

	static Integer[] fi = {0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int idx = 22;
			int k = sc.nextInt();
			int r = 0;
			while (1 == 1) {
				if (k >= fi[idx]) {
					k = k - fi[idx];
					r = r + fi[idx-1];
				}
				idx--;
				if (idx <= 0) break;
			}
			System.out.println(r);
		}
	}
}
