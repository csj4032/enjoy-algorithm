package p11365;

import java.util.Scanner;

public class Main {

	private static Scanner sc;
	private static StringBuilder sb;
	private static StringBuilder rsb;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		sb = new StringBuilder();
		while (true) {
			String str = sc.nextLine();
			rsb = new StringBuilder();
			if (str.equals("END")) break;
			sb.append(rsb.append(str).reverse() + "\n");
		}
		System.out.println(sb.toString());
	}
}