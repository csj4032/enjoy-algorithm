package p10103;

import java.util.Scanner;

public class Main {

	static int SK = 100;
	static int CY = 100;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int sk = sc.nextInt();
			int cy = sc.nextInt();
			if (sk < cy) {
				SK = SK - cy;
			} else if (sk > cy) {
				CY = CY - sk;
			}
		}

		System.out.println(SK);
		System.out.println(CY);
	}
}