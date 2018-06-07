package p10801;

import java.util.Scanner;

public class Main {

	static int a[] = new int[10];
	static int b[] = new int[10];
	static int c = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) a[i] = sc.nextInt();
		for (int i = 0; i < 10; i++) b[i] = sc.nextInt();

		for (int i = 0; i < 10; i++) {
			if (a[i] > b[i]) {
				c++;
			} else if (a[i] < b[i]) {
				c--;
			}
		}

		if (c == 0) {
			System.out.println("D");
		} else if (c > 0) {
			System.out.println("A");
		} else if (c < 0) {
			System.out.println("B");
		}
	}
}
