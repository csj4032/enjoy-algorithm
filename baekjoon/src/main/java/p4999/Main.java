package p4999;

import java.util.Scanner;

// 아!
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		String m = sc.next();

		int h1 = n.lastIndexOf("h");
		int h2 = m.lastIndexOf("h");

		//System.out.println(h1 + " " + h2);
		if (h1 >= h2) {
			System.out.println("go");
		} else {
			System.out.println("no");
		}
	}
}
