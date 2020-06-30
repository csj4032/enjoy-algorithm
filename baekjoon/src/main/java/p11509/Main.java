package p11509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] nn = br.readLine().split(" ");
		int[] l = new int[100001];
		int k = 0;
		for (int i = 0; i < n; i++) {
			int j = Integer.parseInt(nn[i]);
			if (l[j + 1] > 0) {
				l[j + 1]--;
				l[j]++;
			} else {
				l[j]++;
				k++;
			}
		}
		System.out.println(k);
	}
}