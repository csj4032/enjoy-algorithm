package baekjoon.p8393;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		System.out.println(IntStream.rangeClosed(1, new Scanner(System.in).nextInt()).sum());
	}
}