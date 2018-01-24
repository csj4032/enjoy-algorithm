package p1057;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = 0;
		boolean f = false;
		int[] l = new int[n];

		for (int i = 0; i < n; i++) {
			l[i] = i + 1;
		}

		while (true) {
			int m = (int) Math.ceil((double) n / 2.0);
			int[] mm = new int[m];

			for (int i = 0; i < m; i++) {
				if (l[i * 2] == a || l[i * 2] == b) {
					if (i * 2 + 1 < n && (l[i * 2 + 1] == a || l[i * 2 + 1] == b)) {
						f = true;
						break;
					}
				}

				mm[i] = l[i * 2];
				if (l[i * 2] == a || l[i * 2] == b) mm[i] = l[i * 2];
				if (i * 2 + 1 < n) {
					if (l[i * 2 + 1] == a || l[i * 2 + 1] == b) {
						mm[i] = l[i * 2 + 1];
					}
				}
			}

			c++;
			n = m;
			l = Arrays.copyOfRange(mm, 0, mm.length);

			if (n == 1 || f == true) {
				break;
			}
		}

		System.out.println(f == false ? -1 : c);
	}
}