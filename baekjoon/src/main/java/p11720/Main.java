package p11720;

import java.util.Arrays;
		import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] m = sc.next().split("");
		System.out.println(Arrays.stream(m).mapToInt(i-> Integer.valueOf(i)).sum());
	}
}