package p14681;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var x = sc.nextInt();
		var y = sc.nextInt();
		var q = 0;
		if (x > 0 && y > 0) {
			q = 1;
		} else if (x < 0 && y > 0) {
			q = 2;
		} else if (x < 0 && y < 0) {
			q = 3;
		} else if (x > 0 && y < 0) {
			q = 4;
		}
		System.out.println(q);
	}
}