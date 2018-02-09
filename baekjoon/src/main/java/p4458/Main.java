package p4458;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.valueOf(sc.nextLine());
		for (int i = 0; i < n; i++) {
			String s = sc.nextLine();
			String f = s.substring(0,1).toUpperCase();
			System.out.println(s.replaceFirst("^[a-z]", f));
		}
	}
}