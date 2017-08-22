package p1427;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split("");
		Arrays.sort(str, Collections.reverseOrder());
		Stream.of(str).forEach(e -> System.out.print(e));
	}
}