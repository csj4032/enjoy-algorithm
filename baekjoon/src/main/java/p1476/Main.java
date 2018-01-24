package p1476;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int i = 1;

		while (true) {
			int aa = i % 15;
			int bb = i % 28;
			int cc = i % 19;

			if (aa == 0) aa = 15;
			if (bb == 0) bb = 28;
			if (cc == 0) cc = 19;

			if (aa == a && bb == b && cc == c) {
				System.out.println(i);
				break;
			}

			i++;
		}
	}
}