package p9093;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.valueOf(sc.nextLine());

		for (int i = 0; i < t; i++) {
			StringBuilder sb = new StringBuilder();
			String[] strings = sc.nextLine().split(" ");
			for (String s : strings) {
				StringBuilder sb2 = new StringBuilder();
				sb2.append(s);
				sb2.reverse();
				sb.append(sb2.toString() + " ");
			}
			System.out.println(sb.toString().trim());
		}
	}
}