package baekjoon.p11721;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		String s = new Scanner(System.in).nextLine();
		IntStream.rangeClosed(1, s.length()).forEach(i -> {
			if (i % 10 == 0) {
				System.out.println(s.substring(i - 1, i));
			} else {
				System.out.print(s.substring(i - 1, i));
			}
		});
	}
}