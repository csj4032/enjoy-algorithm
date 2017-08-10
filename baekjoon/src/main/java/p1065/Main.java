package p1065;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		for (int i = 1; i <= n; i++) {
			count += arithmetical(String.valueOf(i).split(""));
		}
		System.out.println(count);
	}

	private static int arithmetical(String[] str) {
		Set<Integer> numbers = new HashSet<>();
		Arrays.stream(str).mapToInt(s -> Integer.valueOf(s)).reduce((a, b) -> {
			numbers.add(a - b);
			return b;
		});
		if (numbers.size() < 2) {
			return 1;
		}
		return 0;
	}
}