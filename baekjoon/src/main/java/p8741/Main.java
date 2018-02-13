package p8741;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (long i = 0; i < n; i++) {
			sb.append("1");
		}
		for (long i = 0; i < n - 1; i++) {
			sb.append("0");
		}
		System.out.println(sb.toString());
	}
}