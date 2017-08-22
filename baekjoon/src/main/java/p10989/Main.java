package p10989;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		int[] n;
		int[] m;
		int max = 0;

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = new int[Integer.parseInt(br.readLine().trim())];

		for (int i = 0; i < n.length; i++) {
			int num = Integer.parseInt(br.readLine().trim());
			n[i] = num;
			if (max < num) {
				max = num;
			}
		}

		m = new int[max + 1];

		for (int i = 0; i < n.length; i++) {
			m[n[i]]++;
		}

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i]; j++) {
				bw.write(i + "\n");
			}
		}
		bw.close();
	}
}