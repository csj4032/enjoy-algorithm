package p2884;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		int t = (h * 60) + m - 45;
		if (t < 0) {
			t = (24 * 60) + t;
		}
		//System.out.println((t - (t % 60)) / 60 % 24 + " " + String.format("%02d", t % 60));
		System.out.println((t - (t % 60)) / 60 % 24 + " " + t % 60);
	}
}