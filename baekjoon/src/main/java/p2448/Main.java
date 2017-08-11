package p2448;

import java.util.Scanner;
import java.util.stream.Stream;

import static java.lang.System.in;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(in);
		String[] arr;
		int copyHeight = 3;
		int n = sc.nextInt();
		int m = (int) (Math.log(n / 3) / Math.log(2)) + 1;
		arr = new String[n];

		arr[0] = "  *  ";
		arr[1] = " * * ";
		arr[2] = "*****";

		for (int i = 1; i < m; i++) {
			for (int j = 0; j < copyHeight; j++) {
				arr[copyHeight + j] = arr[j] + " " + arr[j];
				for (int k = 0; k < copyHeight / 3; k++) {
					arr[j] = "   " + arr[j] + "   ";
				}
			}
			copyHeight *= 2;
		}

		Stream.of(arr).forEach(System.out::println);
	}
}