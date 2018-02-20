package p2003;

/**
 * 제목 : 수들의 합 2
 */
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t = sc.nextInt();
		int[] m = new int[10001];

		for (int i = 0; i < n; i++) {
			m[i] = sc.nextInt();
		}

		int start = 0;
		int end = 0;
		int sum = 0;
		int count = 0;

		while (end <= n) {

			if (sum < t) sum += m[end++];
			if (sum > t) sum -= m[start++];

			if (sum == t) {
				sum -= m[start++];
				count++;
			}
		}

		System.out.println(count);
	}
}