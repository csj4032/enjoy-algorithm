package p6502;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		Scanner sc = new Scanner(System.in);
		int i = 1;
		while (true) {
			String n = sc.nextLine();
			if (n.equals("0")) return;
			isFits(n, i);
			i++;
		}
	}

	private static void isFits(String n, int i) {
		String[] m = n.split(" ");
		float a = Float.parseFloat(m[0]);
		float b = Float.parseFloat(m[1]);
		float c = Float.parseFloat(m[2]);
		if (Math.pow(a, 2) >= (Math.pow(b / 2, 2) + Math.pow(c / 2, 2))) {
			System.out.printf("Pizza %d fits on the table.\n", i);
		} else {
			System.out.printf("Pizza %d does not fit on the table.\n", i);
		}
	}
}