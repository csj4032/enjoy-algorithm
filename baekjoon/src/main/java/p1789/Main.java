package p1789;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		int i = 1;
		while (true) {
			n = n - i;
			if(n < 0) {
				i--;
				break;
			}
			i++;
		}
		System.out.println(i);
	}
}