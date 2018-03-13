package p1676;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();
		int count = 0;
		for (int i = 1; i <= n; i++) {
			int t = i;
			while (t % 5 == 0) {
				count++;
				t = t / 5;
			}
		}
		System.out.println(count);
	}
}