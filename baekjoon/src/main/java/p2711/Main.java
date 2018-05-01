package p2711;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i <t ; i++) {
			int n = sc.nextInt();
			StringBuilder sb = new StringBuilder(sc.next());
			sb.deleteCharAt(n-1);
			System.out.println(sb.toString());
		}
	}
}
