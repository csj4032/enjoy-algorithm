package p11945;

import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);

		String[] lines = new String[11];

		for (int i = 0; i < n; i++) {
			lines[i] = br.readLine();
		}

		for (int i = 0; i < n; i++) {
			for (int j = m - 1; j >= 0; j--) {
				bw.write(lines[i].charAt(j));
			}
			bw.write("\n");
		}
		bw.flush();
	}
}