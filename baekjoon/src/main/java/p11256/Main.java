package p11256;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var t = sc.nextInt();
		var sb = new StringBuilder();

		for (int i = 0; i < t; i++) {
			var n = sc.nextInt();
			var m = sc.nextInt();
			var mm = new Integer[m];
			for (int j = 0; j < m; j++) {
				mm[j] = sc.nextInt() * sc.nextInt();
			}
			Arrays.sort(mm, Comparator.reverseOrder());
			int k = 1;
			for (int j = 0; j < m; j++) {
				n = n - mm[j];
				if (n <= 0) break;
				k++;
			}
			sb.append(k + " \n");
		}
		System.out.println(sb.toString());
	}
}
