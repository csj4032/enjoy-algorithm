package p5218;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			String[] str = sc.nextLine().split(" ");
			String first = str[0];
			String second = str[1];
			StringBuilder sb = new StringBuilder("Distances: ");
			for (int j = 0; j < first.length(); j++) {
				char a = first.charAt(j);
				char b = second.charAt(j);
				int c = 0;
				if (a <= b) {
					c = b - a;
				} else {
					c = 26 - Math.abs(a - b);
				}
				sb.append(c + " ");
			}
			System.out.print(sb.toString().trim() + "\n");
		}
	}
}