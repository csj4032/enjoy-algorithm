package p9658;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n % 7 == 1 ||  n % 7 == 3) {
			System.out.println("CY");
		} else {
			System.out.println("SK");
		}
	}
}