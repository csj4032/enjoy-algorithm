import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class CardReverse {

	static Integer[] cards = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

	public static void main(String[] args) {
		Scanner sc = new Scanner(in);
		int[][] n = new int[10][2];

		for (int i = 0; i < 10; i++) {
			n[i][0] = sc.nextInt();
			n[i][1] = sc.nextInt();
		}

		for (int i = 0; i < 10; i++) {
			int s = n[i][0];
			int e = n[i][1];

			int l = e - s + 1;
			int t[] = new int[l];

			for (int j = s; j <= e; j++) {
				t[j - s] = cards[j - 1];
			}

			for (int j = s; j <= e; j++) {
				cards[j - 1] = t[e - j];
			}
		}

		System.out.println(Arrays.toString(cards));
	}
}