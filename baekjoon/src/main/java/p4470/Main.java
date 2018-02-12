package p4470;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());

		String[] m = new String[n];
		for (int i = 0; i < n; i++) {
			String t = sc.nextLine();
			m[i] = t;
		}

		for (int i = 0; i < n; i++) {
			System.out.printf("%d. %s\n", i + 1, m[i]);
		}
	}
}