package p3059;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			String word = sc.next();
			int k = 0;
			for (char ch = 'A'; ch <= 'Z'; ch++) {
				if (!word.contains(String.valueOf(ch))) {
					k += ch + 0;
				}
			}
			System.out.println(k);
		}
	}
}