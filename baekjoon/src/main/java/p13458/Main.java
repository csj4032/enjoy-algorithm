package p13458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 제목 : 시험 감독
 * 풀이 : 감독관의 숫자가 생각보다 클 수 있음
 */
public class Main {

	private static Scanner sc;
	private static int[] m;
	private static int n;
	private static int a;
	private static int b;
	private static long t;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = new int[1000001];

		String[] nums = br.readLine().split(" ");
		for (int i = 0; i < n; i++) m[i] = Integer.parseInt(nums[i]);

		String[] ma = br.readLine().split(" ");
		a = Integer.parseInt(ma[0]);
		b = Integer.parseInt(ma[1]);

		for (int i = 0; i < n; i++) {
			long k = m[i];
			long l = k - a;
			t += 1;
			if (l > 0) {
				t += (l / b);
				t += (l % b == 0) ? 0 : 1;
			}
		}
		System.out.println(t);
	}
}
