package p2902;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String[] words = new Scanner(System.in).nextLine().split("-");
		StringBuilder result = new StringBuilder();
		for (int i = 0; i <  words.length; i++) {
			result.append(words[i].charAt(0));
		}
		System.out.println(result.toString());
	}
}