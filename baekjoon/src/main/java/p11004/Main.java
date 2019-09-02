package p11004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static Long[] numbers;

	public static void main(String[] args) throws IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(sc.readLine());
		int n = Integer.valueOf(st.nextToken());
		int k = Integer.valueOf(st.nextToken());
		st = new StringTokenizer(sc.readLine());
		numbers = new Long[n];
		int i = 0;
		while (st.hasMoreTokens()) {
			numbers[i] = Long.valueOf(st.nextToken());
			i++;
		}

		Arrays.sort(numbers);
		System.out.println(numbers[k - 1]);
	}
}