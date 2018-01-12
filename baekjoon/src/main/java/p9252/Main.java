package p9252;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] a = sc.next().split("");
		String[] b = sc.next().split("");
		int n = a.length;
		int m = b.length;
		for (int i = 0; i < n; i++) {
			String c = "";
			for (int j = i; j < n; j++) {
				for (int k = j; k < m; k++) {
					if (a[j].equals(b[k])) {
						c += b[k];
						break;
					}
				}
			}
			System.out.println(c);
		}
	}
}