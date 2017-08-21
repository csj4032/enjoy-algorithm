package p6064;

import java.util.Scanner;

// 최소공배수만큼 반복 m,n를 나눈뒤 x, y와 동일한지 찾는다 (시간초과)
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			System.out.println(caingang(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
	}

	private static int caingang(int m, int n, int x, int y) {
		int a = Math.max(m, n);
		int b = Math.min(m, n);
		int lcm = m * n / gcd(a, b);
		while (x != y && y <= lcm) {
			if (x < y) x += m;
			else y += n;
		}
		if (x!= y) return -1;
		else return x;
	}

	private static int gcd(int a, int b) {
		return (a % b == 0 ? b : gcd(b, a % b));
	}
}