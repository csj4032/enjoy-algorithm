package p11024;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.valueOf(sc.nextLine());

		for (int i = 0; i < t; i++) {
			int sum = 0;
			StringTokenizer s = new StringTokenizer(sc.nextLine());
			while (s.hasMoreTokens()) {
				sum += Integer.parseInt(s.nextToken());
			}
			System.out.print(sum + "\n");
		}
	}
}