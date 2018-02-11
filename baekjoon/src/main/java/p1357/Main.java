package p1357;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();

		StringBuilder sb = new StringBuilder(a);
		StringBuilder sb2 = new StringBuilder(b);

		Integer aa = Integer.parseInt(sb.reverse().toString());
		Integer bb = Integer.parseInt(sb2.reverse().toString());

		StringBuilder sb3 = new StringBuilder(String.valueOf(aa+bb));

		System.out.println(Integer.parseInt(sb3.reverse().toString()));
	}
}