package p10872;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long m = 1;
		while (--n > 0) {
			m += m * n;
		}
		System.out.println(m);
	}
}