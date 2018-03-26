package p15552;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine().trim());
		int[] m = new int[t];

		for (int i = 0; i < t; i++) {
			String[] line = br.readLine().split(" ");
			m[i] = Integer.parseInt(line[0]) + Integer.parseInt(line[1]);
		}

		for (int i = 0; i < t; i++) {
			bw.write(m[i] + "\n");
		}

		bw.flush();
	}
}