package p2010;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = 0;
		for (int i = 0; i < n; i++) {
			s = s + sc.nextInt();
		}
		System.out.println(s - (n - 1));
	}
}