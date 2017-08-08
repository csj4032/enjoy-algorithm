package p1924;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();

		int t = n;

		for (int i = 1; i < m; i++) {
			t = t + months[i - 1];
		}

		System.out.println(week[t % 7]);
	}
}
