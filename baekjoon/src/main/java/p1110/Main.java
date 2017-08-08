package p1110;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(cycle(n, n, 0));
	}

	private static int cycle(int n, int m, int c) {
		c++;
		String str1[] = String.format("%02d", m).split("");
		String str2[] = String.format("%02d", Arrays.stream(str1).mapToInt(i -> Integer.valueOf(i)).sum()).split("");
		int k = Integer.parseInt(str1[1] + str2[1]);
		if (n == k) return c;
		return cycle(n, k, c);
	}
}