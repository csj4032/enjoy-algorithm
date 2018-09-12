package p4963;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			if (w == 0 && h == 0) break;

			int k = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					int l = sc.nextInt();
					if (l == 1) k++;
				}
			}
			System.out.println(k);
		}
	}
}