package p10039;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			int score = sc.nextInt();
			sum += score < 40 ? 40 : score;
		}
		System.out.println(sum / 5);
	}
}