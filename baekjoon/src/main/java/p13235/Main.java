package p13235;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] strings = sc.next().split("");
		System.out.println(palindromes(strings));
	}

	private static boolean palindromes(String[] strings) {
		int s = 0;
		int e = strings.length - 1;
		while (s < e) {
			if (!strings[s++].equals(strings[e--])) return false;
		}
		return true;
	}
}