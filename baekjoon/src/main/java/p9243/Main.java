package p9243;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String a = sc.next();
		String b = sc.next();

		if ((n & 1) == 0) {
			for (int i = 0; i < a.length(); i++) {
				if (a.charAt(i) != b.charAt(i)) {
					System.out.println("Deletion failed");
					return;
				}
			}
			System.out.println("Deletion succeeded");
		} else {
			for (int i = 0; i < a.length(); i++) {
				if (a.charAt(i) == b.charAt(i)) {
					System.out.println("Deletion failed");
					return;
				}
			}
			System.out.println("Deletion succeeded");
		}
	}
}