package p11007;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	static List<String> alphabet;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var t = sc.nextInt();
		var sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			var n = sc.nextInt();
			alphabet = init();
			for (int j = 0; j < n; j++) {
				var k = sc.nextInt();
				var a = alphabet.remove(k);
				alphabet.add(0, a);
				sb.append(a);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static List<String> init() {
		return Stream.of("abcdefghijklmnopqrstuvwxyz".split("")).collect(Collectors.toList());
	}
}
