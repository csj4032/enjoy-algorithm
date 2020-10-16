package p14912;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var d = sc.next();
		var l = new ArrayList<Stream<String>>();
		for (int i = 1; i <= n; i++) {
			var dd = Arrays.stream(String.valueOf(i).split(""));
			l.add(dd);
		}
		var ll = l.stream().flatMap(stringStream -> stringStream).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(ll.get(d));
	}
}