package p2863;

import java.util.Scanner;

/**
 * 제목 : 이게 분수?
 * 링크 : https://www.acmicpc.net/problem/2863
 * 분류 : 수학
 * Least Common Multiple
 * 0 --> 1
 * 1 --> 3
 * 2 --> 0
 * 3 --> 2
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();
		double d = sc.nextDouble();
		double[] e = new double[4];

		double ee[][] = new double[4][4];

		ee[0] = new double[]{a, b, c, d};
		ee[1] = new double[]{c, a, d, b};
		ee[2] = new double[]{d, c, b, a};
		ee[3] = new double[]{b, d, a, c};

		int idx = 0;
		double max = 0;
		for (int i = 0; i < 4; i++) e[i] = calculate(ee[i]);

		for (int i = 0; i < 4; i++) {
			if (max < e[i]) {
				max = e[i];
			}
		}

		for (int i = 0; i < 4; i++) {
			if(max == e[i]) {
				idx = i;
				break;
			}
		}

		System.out.println(idx);
	}

	private static double calculate(double[] abcd) {
		return (abcd[0] / abcd[2]) + (abcd[1] / abcd[3]);
	}
}
