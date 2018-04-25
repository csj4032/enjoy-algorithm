package p4150;

import java.io.*;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		BigInteger[] m = new BigInteger[n+1];

		m[0] = BigInteger.ZERO;
		m[1] = BigInteger.ONE;

		for (int i = 2; i <= n; i++) {
			m[i] = m[i - 2].add(m[i - 1]);
		}

		bw.write(m[n].toString());
		bw.flush();
		bw.close();
		br.close();
	}
}