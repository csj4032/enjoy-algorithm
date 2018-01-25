package p11656;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		int m = n.length();
		String[] l = new String[m];

		for (int i = 0; i < m; i++) {
			l[i] = n.substring(i);
		}

		Arrays.stream(l).sorted().forEach(e-> System.out.println(e));
	}
}