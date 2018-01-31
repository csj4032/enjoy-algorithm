package p14495;

import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long k = Stream.iterate(new long[]{1, 1, 1}, t -> new long[]{t[1], t[2], t[2] + t[0]}).limit(n).mapToLong(t -> t[0]).max().orElse(0);
		System.out.println(k);
	}
}