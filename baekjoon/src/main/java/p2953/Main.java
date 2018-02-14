package p2953;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = 0;
		int t = 0;
		for (int i = 0; i < 5; i++) {
			int s = 0;
			for (int j = 0; j < 4; j++) {
				s += sc.nextInt();
			}
			if (k < s) {
				k = s;
				t = i + 1;
			}
		}
		System.out.println(t + " " + k);
	}
}