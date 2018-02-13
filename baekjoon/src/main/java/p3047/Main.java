package p3047;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] m = new int[3];
		m[0] = sc.nextInt();
		m[1] = sc.nextInt();
		m[2] = sc.nextInt();
		Arrays.sort(m);
		String[] s = sc.next().split("");

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length; i++) {
			if (s[i].equals("A")) sb.append(m[0]).append(" ");
			if (s[i].equals("B")) sb.append(m[1]).append(" ");
			if (s[i].equals("C")) sb.append(m[2]).append(" ");
		}

		System.out.println(sb.toString().trim());
	}
}