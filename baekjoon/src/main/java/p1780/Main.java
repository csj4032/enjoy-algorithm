package p1780;

import java.util.Scanner;

public class Main {

	static long k[] = new long[3];
	static int m[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		m = new int[2200][2200];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				m[i][j] = sc.nextInt();
			}
		}

		paper(0, 0, n);
		System.out.println(k[0]);
		System.out.println(k[1]);
		System.out.println(k[2]);
	}

	private static void paper(int p, int q, int n) {
		if (count(p, q, n)) {
			k[m[p][q] + 1] += 1;
			return;
		} else {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					paper(p + i * (n / 3), q + j * (n / 3), n / 3);
				}
			}
		}
	}

	private static boolean count(int p, int q, int n) {
		int k = m[p][q];
		for (int i = p; i < p + n; i++) {
			for (int j = q; j < q + n; j++) {
				if (k != m[i][j]) return false;
			}
		}
		return true;
	}
}
// ABC
// ABEEBCABC

//	 A B C
//A  1 0 0
//B  0 2 0
//E  0 0 0
//E  0 0 0
//B  0 1 0
//C  0 0 2
//A  1 0 0
//B  0 2 0
//C  0 0 3