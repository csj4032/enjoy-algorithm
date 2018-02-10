package p13410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] ins = br.readLine().split(" ");
		int n = Integer.parseInt(ins[0]);
		int k = Integer.parseInt(ins[1]);
		int max = 0;

		while (k > 0) {
			int t = 0;
			int j = k * n;
			t = getReverse(j, t);
			if (max < t) {
				max = t;
			}
			k--;
		}
		System.out.println(max);
	}

	private static int getReverse(int j, int t) {
		while (j > 0) {
			t *= 10;
			t += j % 10;
			j /= 10;
		}
		return t;
	}
}