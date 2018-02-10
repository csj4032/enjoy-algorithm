package p11816;

import java.util.Scanner;

// 8진수, 10진수, 16진수
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		int k = 10;

		if (n.matches("(^0x).+")) {
			n = n.replaceFirst("0x", "");
			k = 16;
		}

		if (n.matches("(^0).+")) {
			n = n.replaceFirst("^0", "");
			k = 8;
		}

		System.out.println(Integer.parseInt(n, k));
	}
}