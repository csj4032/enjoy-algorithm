package p1193;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt(), i = 1;
		while (true) {
			n = n - i;
			if (n <= 0) {
				if (i % 2 == 1) {
					System.out.println((1 - n) + "/" + (i + n));
				} else {
					System.out.println(i + n + "/" + (1 - n));
				}
				break;
			}
			i++;
		}
	}
}