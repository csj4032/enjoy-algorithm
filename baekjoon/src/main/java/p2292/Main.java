package p2292;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = 1, j = 1, i = 1;
		while (true) {
			if (n > j) {
				m++;
				j = j + 6 * i;
				i++;
			} else {
				break;
			}
		}
		System.out.println(m);
	}
}