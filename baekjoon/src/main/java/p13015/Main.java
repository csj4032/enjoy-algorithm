package p13015;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w = n + n + (n - 2) + (n - 1);
		int h = n * 2 - 1;
		for (int i = 0; i < h; i++) {
			int l = i + n - 1;
			int r = w - n - i;
			for (int j = 0; j < w; j++) {
				if ((i == 0 || i == h - 1) && (j < n || j >= w - n) || (j == l) || (j == r) || (i < n && j == i) || (i < n && j == (w - i - 1)) || (i >= n && i == h - j - 1) || (i >= n && i == j - n - n + 2)) {
					System.out.print('*');
				} else {
					if ((i < n && j < w - i) || (i >= n && j <= n + i + (n / 2) + (n % 2 == 0 ? (n / 2) - 2 : (n / 2) - 1))) {
						System.out.print(' ');
					}
				}
			}
			System.out.println();
			l++;
			r--;
		}
	}
}