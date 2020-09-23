package p2998;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var big = new BigInteger(sc.next(), 2);
		System.out.println(big.toString(8));
	}
}