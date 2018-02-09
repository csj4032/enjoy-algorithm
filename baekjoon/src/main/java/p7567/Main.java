package p7567;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		String[] m = n.split("");
		int k = 10;
		String f = m[0];
		for (int i = 1; i < m.length; i++) {
			if (f.equals(m[i])) {
				k += 5;
			} else {
				k += 10;
				f = m[i];
			}
		}
		System.out.println(k);
	}
}