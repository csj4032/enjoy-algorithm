package p5363;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < n; i++) {
			String[] words = sc.nextLine().split(" ");
			StringBuilder sb = new StringBuilder();
			for (int j = 2; j < words.length; j++) {
				sb.append(words[j]);
				sb.append(" ");
			}
			sb.append(words[0]);
			sb.append(" ");
			sb.append(words[1]);
			System.out.println(sb.toString());
		}
	}
}
