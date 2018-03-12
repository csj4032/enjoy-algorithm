package p9659;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		if ((new Scanner(System.in).nextLong() & 1) == 0) {
			System.out.println("CY");
		} else {
			System.out.println("SK");
		}
	}
}