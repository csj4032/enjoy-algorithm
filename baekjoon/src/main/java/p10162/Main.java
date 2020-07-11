package p10162;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var t = sc.nextInt();
		var sb = new StringBuilder();
		if (t % 10 != 0) {
			System.out.println(-1);
		} else {
			sb.append(t / 300 + " ");
			t %= 300;
			sb.append(t / 60 + " ");
			t %= 60;
			sb.append(t / 10);
		}
		System.out.println(sb.toString());
	}
}