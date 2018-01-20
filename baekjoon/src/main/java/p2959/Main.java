package p2959;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] m = new int[4];
		m[0] = sc.nextInt();
		m[1] = sc.nextInt();
		m[2] = sc.nextInt();
		m[3] = sc.nextInt();
		Arrays.sort(m);
		System.out.println(m[0] * m[2]);
	}
}