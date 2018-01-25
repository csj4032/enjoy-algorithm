package p10808;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.stream.Collectors.joining;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		char[] m = n.toCharArray();
		int[] l = new int[26];

		for (char s : m) {
			l[m[s] - 97] += 1;
		}

		System.out.println(Arrays.stream(l).mapToObj(StringBuilder::new).collect(joining(" ")));
	}
}