package p14915;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		var m = sc.nextInt();
		var n = sc.nextInt();
		System.out.println(Integer.toString(m, n).toUpperCase());
	}
}
