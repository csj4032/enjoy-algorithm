package p5893;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger bigInteger = new BigInteger(sc.next(), 2).multiply(new BigInteger("17"));
		System.out.println(bigInteger.toString(2));
	}
}