package p5598;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		char[] chars = new Scanner(System.in).next().toCharArray();
		for (int i = 0; i < chars.length; i++) chars[i] = (char) (((26 + chars[i] - 65 - 3) % 26) + 65);
		System.out.println(String.valueOf(chars));
	}
}