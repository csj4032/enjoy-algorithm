package p10988;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		boolean bool = true;

		char[] chars = word.toCharArray();
		char[] chars2 = new char[chars.length];

		for (int i = 0; i < chars.length; i++) {
			chars2[i] = chars[chars.length - 1 - i];
		}

		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != chars2[i]) {
				bool = false;
			}
		}

		if (bool) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
	}
}