package p5704;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer[] alphabets = new Integer[26];
		while (true) {
			String str = sc.nextLine();
			Arrays.fill(alphabets, 0);
			if (str.equals("*")) break;
			for (int i = 0; i < str.length(); i++) {
				int k = str.charAt(i) - 97;
				if (k >= 0) alphabets[k] = 1;
			}
			if (Arrays.stream(alphabets).allMatch(i -> i == 1)) {
				System.out.println("Y");
			} else {
				System.out.println("N");
			}
		}
	}
}