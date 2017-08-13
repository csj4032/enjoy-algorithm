package p8958;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> list = new ArrayList();
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int c = 0;
			Stream.of(sc.next().split("")).reduce((a, b) -> {
				if (a.equals("O") && b.equals(a)) {

				}
				return b;
			});
		}
	}
}