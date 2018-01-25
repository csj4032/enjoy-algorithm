package p10808;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		char[] m = n.toCharArray();
		Integer[] l = new Integer[26];
		Arrays.fill(l, 0);
		for (char i : m) {
			l[i - 97] += 1;
		}

		System.out.println(Stream.of(l).map(String::valueOf).collect(joining(" ")));
	}
}
