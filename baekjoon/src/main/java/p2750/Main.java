package p2750;

import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Integer[] m = new Integer[n];
		for (int i = 0; i < n; i++) {
			m[i] = sc.nextInt();
		}
		Stream.of(m).sorted().forEach(e -> System.out.println(e));
	}
}