package p1159;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] m = new String[n];

		for (int i = 0; i < n; i++) {
			m[i] = sc.next();
		}

		List<String> list = Arrays.stream(m)
				.map(e -> e.substring(0, 1))
				.sorted()
				.collect(groupingBy(Function.identity(), counting()))
				.entrySet()
				.stream()
				.filter(e -> e.getValue() >= 5)
				.map(e-> e.getKey())
				.collect(toList());

		if(list.isEmpty()) {
			System.out.println("PREDAJA");
		} else{
			list.stream().forEach(System.out::print);
		}
	}
}