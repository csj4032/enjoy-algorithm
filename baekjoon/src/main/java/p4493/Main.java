package p4493;

import java.util.Scanner;

public class Main {

	private static int t;
	private static int[] round;
	private static Scanner sc;

	public static void main(String[] args) {
		init();
		match();
		print();
	}

	private static void print() {
		for (int i = 0; i < t; i++) {
			if (round[i] == 0) System.out.println("TIE");
			if (round[i] > 0) System.out.println("Player 1");
			if (round[i] < 0) System.out.println("Player 2");
		}
	}

	private static void match() {
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int r = 0;
			for (int j = 0; j < n; j++) {
				char p1 = sc.next().charAt(0);
				char p2 = sc.next().charAt(0);
				r += match(p1, p2);
			}
			round[i] = r;
		}
	}

	private static void init() {
		sc = new Scanner(System.in);
		t = sc.nextInt();
		round = new int[t];
	}

	private static int match(char p1, char p2) {
		int temp = p1 - p2;
		if (temp == 1 || temp == 2 || temp == -3) {
			return 1;
		} else if (temp == 0) {
			return 0;
		} else {
			return -1;
		}
	}
}
