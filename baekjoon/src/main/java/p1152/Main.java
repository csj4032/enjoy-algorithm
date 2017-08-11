package p1152;

import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println((Stream.of(sc.nextLine().split(" ")).filter(s -> !"".equals(s)).count()));
	}
}