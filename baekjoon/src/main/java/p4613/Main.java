package p4613;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String words = sc.nextLine();
			if (words.equals("#")) break;
			int l = words.length();
			int k = 0;
			for (int i = 0; i < l; i++) {
				char c = words.charAt(i);
				if (c == 32) {
					k += 0;
				} else {
					k += (c - 64) * (i + 1);
				}
			}
			System.out.println(k);
		}
	}
}