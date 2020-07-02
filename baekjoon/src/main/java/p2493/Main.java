package p2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		var n = Integer.parseInt(br.readLine());
		var sb = new StringBuilder();
		var s = new Stack<Integer>();
		var st = br.readLine().split(" ");
		var f = Integer.parseInt(st[0]);
		for (int i = 1; i < n; i++) {
			var ss = Integer.parseInt(st[i]);
			if(f < ss) {

			}
		}

		while (!s.isEmpty()) {
			var t = s.peek();
			var k = 0;
			s.pop();
			for (int i = 0; i < s.size(); i++) {
				if (s.get(i) > t) k = i + 1;
			}
			sb.insert(0, k + " ");
		}
		System.out.println(sb.toString().trim());
	}
}