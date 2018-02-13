package p2693;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int[] m = new int[10];
			for (int j = 0; j < 10; j++) m[j] = sc.nextInt();
			Arrays.sort(m);
			System.out.println(m[7]);
		}
	}
}