package p15814;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var s = sc.nextLine().split("");
		var n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			var a = sc.nextInt();
			var b = sc.nextInt();
			var t = s[a];
			s[a] = s[b];
			s[b] = t;
		}
		System.out.println(Arrays.stream(s).collect(Collectors.joining()));
	}
}
