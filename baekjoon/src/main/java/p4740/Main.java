package p4740;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String word = sc.nextLine();
			if (word.equals("***")) break;
			StringBuilder sb = new StringBuilder(word);
			System.out.println(sb.reverse().toString());
		}
	}
}