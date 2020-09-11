package p13458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 제목 : 시험 감독
 * 풀이 : 감독관의 숫자가 생각보다 클 수 있음
 */
public class Main {

	public static void main(String[] args) throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		var n = Integer.parseInt(br.readLine());
		var m = new int[1000001];

		var nums = br.readLine().split(" ");
		for (int i = 0; i < n; i++) m[i] = Integer.parseInt(nums[i]);

		var ma = br.readLine().split(" ");
		var a = Integer.parseInt(ma[0]);
		var b = Integer.parseInt(ma[1]);
		var t = 0;

		for (int i = 0; i < n; i++) {
			long l = m[i] - a;
			t += 1;
			if (l > 0) {
				t += (l / b);
				t += (l % b == 0) ? 0 : 1;
			}
		}
		System.out.println(t);
	}
}
