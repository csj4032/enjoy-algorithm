package p14928;

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * https://ko.khanacademy.org/computing/computer-science/cryptography/modarithmetic/a/modular-exponentiation
 * System.out.println(130000000L % 20000303);
 * System.out.println((100000000L % 20000303 + (10000000L % 20000303) * 3) % 20000303);
 */
public class Main {

	static BigInteger modular = new BigInteger("20000303");
	static BigInteger result = BigInteger.ZERO;
	static BigInteger decimal = BigInteger.TEN;

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//		String numbers = br.readLine();
//		int length = numbers.length();
//
//		for (int i = length - 1; i >= 0; i--) {
//			BigInteger exponent = new BigInteger(String.valueOf(i));
//			BigInteger first = new BigInteger(String.valueOf(numbers.charAt(length - i - 1)));
//			result = result.add(decimal.modPow(exponent, modular).mod(modular).multiply(first));
//		}
//
//		bw.write(result.mod(modular).toString());
//		bw.flush();

		char[] N = new Scanner(System.in).next().toCharArray();

		int remainder = 0;
		for (int i = 0; i < N.length; i++) {
			remainder = (remainder * 10 + N[i] - '0') % 20000303;
			System.out.println(remainder);
		}

		System.out.print(remainder);
	}
}