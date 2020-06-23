package p1644;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 제목 : 소수의 연속합
 * 링크 : https://www.acmicpc.net/problem/1644
 * 분류 : 에라토스테네스의 체, 정수론, 투 포인터
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t = 0;
		boolean[] m = new boolean[n + 1];
		List<Integer> prime = new ArrayList<>();
		Arrays.fill(m, true);

		m[0] = false;
		m[1] = false;

		for (int i = 2; i <= Math.sqrt(n); i++) if (m[i]) for (int j = i * i; j <= n; j += i) m[j] = false;
		for (int i = 2; i <= n; i++) if (m[i] == true) prime.add(i);

		for (int i = 0; i < prime.size(); i++) {
			int k = 0;
			for (int j = i; j < prime.size(); j++) {
				k += prime.get(j);
				if (k == n) {
					t++;
					break;
				}
				if(k > n) break;
			}
		}
		System.out.println(t);
	}
}