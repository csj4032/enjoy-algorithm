package p2744;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) { ;
		String str = new Scanner(System.in).nextLine();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c > 90) {
				sb.append((char) (c - 32));
			} else {
				sb.append((char) (c + 32));
			}
		}
		System.out.print(sb.toString());
	}
}