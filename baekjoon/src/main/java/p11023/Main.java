package p11023;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println(Arrays.stream(new Scanner(System.in).nextLine().split("\\s")).mapToInt(Integer::new).sum());
	}
}