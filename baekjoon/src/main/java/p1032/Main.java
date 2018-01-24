package p1032;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] m = new String[n];

		for (int i = 0; i < n; i++) {
			m[i] = sc.next();
		}

		int l = m[0].length();
		String k[] = new String[l];

		for (int i = 0; i < l; i++) {
			String s = m[0].substring(i, i + 1);
			for (int j = 0; j < n; j++) {
				String ss = m[j].substring(i, i + 1);
				if (s.equals(ss)) {
					k[i] = s;
				} else {
					k[i] = "?";
					break;
				}
			}
		}
		System.out.println(Arrays.stream(k).collect(Collectors.joining()));
	}
}