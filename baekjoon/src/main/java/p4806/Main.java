package p4806;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var k = 0;
		while (sc.hasNextLine() && !sc.nextLine().equals("")) {
			k++;
		}
		System.out.println(k);
	}
}
