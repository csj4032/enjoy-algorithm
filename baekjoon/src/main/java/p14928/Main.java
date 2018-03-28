package p14928;

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * https://ko.khanacademy.org/computing/computer-science/cryptography/modarithmetic/a/modular-exponentiation
 */
public class Main {

	static String m = "20000303";

	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
//		BigInteger n = new BigInteger(sc.next());
//		BigInteger m = BigInteger.TEN;
//
//		int k = 0;
//		while (n.compareTo(new BigInteger("20000303")) > 0) {
//			n = n.divide(BigInteger.TEN);
//			k++;
//		}
//		System.out.println(k);
//		System.out.println(n.mod(new BigInteger("20000303")));
		//System.out.println(100000000000000L%2000303);
		//System.out.println((10000000L%2000303) * (10000000L%2000303)%2000303);


		System.out.println(21100000000000000L % 20000303);
		System.out.println(10000000000000000L % 20000303 + 10000000000000000L % 20000303 + 1000000000000000L % 20000303 + 100000000000000L % 20000303);

		System.out.println(20000000000000000L % 20000303);
		System.out.println(10000000000000000L % 20000303 + 10000000000000000L % 20000303);


		System.out.println((100000000L % 20000303) * (100000000L % 20000303) % 20000303);
		System.out.println(10000000000000000L % 20000303);
	}
}