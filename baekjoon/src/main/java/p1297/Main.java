package p1297;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int h = sc.nextInt();
		int w = sc.nextInt();
		double c = Math.sqrt(h * h + w * w);
		System.out.println((int) (h * n / c) + " " + (int) (w * n / c));
	}
}