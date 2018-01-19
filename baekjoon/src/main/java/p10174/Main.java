package p10174;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();

		String[] m = new String[n];
		for (int i = 0; i < n; i++) {
			m[i] = sc.nextLine();
		}

		for (int i = 0; i < n; i++) {
			System.out.println(isPalindrome(m[i]) ? "Yes" : "No");
		}
	}

	private static boolean isPalindrome(String str) {
		char[] c = str.toLowerCase().toCharArray();
		for (int j = 0; j < c.length / 2; j++) {
			if (c[j] != c[c.length - j - 1]) {
				return false;
			}
		}
		return true;
	}
}