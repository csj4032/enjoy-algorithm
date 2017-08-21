package p10250;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			int n = sc.nextInt();
			System.out.println(solution(h, w, n));
		}
	}

	private static String solution(int h, int w, int n) {
		int f = (n % h == 0 ? h : n % h);
		int g = ((n / h) + ((n % h == 0) ? 0 : 1)) % w == 0 ? w : ((n / h) + ((n % h == 0) ? 0 : 1)) % w;
		return f + "" + (g < 10 ? "0" : "") + g;
	}
}