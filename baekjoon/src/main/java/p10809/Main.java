package p10809;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String str = new Scanner(System.in).next();
		StringBuffer sb = new StringBuffer();
		for (int i = 97; i < 123; i++) {
			char c = (char) i;
			sb.append(str.indexOf(String.valueOf(c)) + " ");
		}
		System.out.println(sb.toString().trim());
	}
}