package p10823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
//		StringBuilder sb = new StringBuilder();
//		while (sc.hasNextLine()) {
//			String line = sc.nextLine();
//			sb.append(line);
//			if (line.length() == 0) break;
//		}
//		Integer sum = Arrays.stream(sb.toString().split(",")).mapToInt(Integer::new).sum();
//		System.out.println(sum);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;

		BigInteger result = new BigInteger("0");

		String str;
		StringBuffer sb = new StringBuffer();
		while ((str = br.readLine()) != null) {
			sb.append(str);
		}

		token = new StringTokenizer(sb.toString());
		while (token.hasMoreTokens()) {
			result = result.add(new BigInteger(token.nextToken(",")));
		}
		System.out.println(result);
	}
}