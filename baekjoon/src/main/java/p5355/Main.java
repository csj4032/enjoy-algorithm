package p5355;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < t; i++) {
			String[] s = sc.nextLine().split(" ");
			double r = cal(s[0], Arrays.copyOfRange(s, 1, s.length));
			System.out.printf("%.2f\n", r);
		}
	}

	private static double cal(String s, String[] strings) {
		double i = Double.parseDouble(s);

		for (int j = 0; j < strings.length; j++) {
			if (strings[j].equals("@")) {
				i = i * 3;
			}
			if (strings[j].equals("%")) {
				i = i + 5;
			}
			if (strings[j].equals("#")) {
				i = i - 7;
			}
		}
		return i;
	}
}
