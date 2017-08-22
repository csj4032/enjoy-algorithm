package p10989;

import java.io.*;

public class Main2 {

	public static void main(String[] args) throws IOException {

		int[] n = new int[10001];
		int m;

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		m = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < m; i++) {
			n[Integer.parseInt(br.readLine().trim())]++;
		}

		for (int i = 0; i < 10001; i++) {
			int num = n[i];
			for (int j = 0; j < num; j++) {
				bw.write(i + "\n");
			}
		}
		bw.close();
	}
}