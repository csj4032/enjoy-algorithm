package p15688;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

	static List<Integer> list = new ArrayList();

	public static void main(String[] args) throws IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(br.readLine().trim()));
		}

		list.sort(Comparator.naturalOrder());

		for (int i = 0; i < n; i++) {
			bw.write(list.get(i) + "\n");
		}

		bw.close();
	}
}