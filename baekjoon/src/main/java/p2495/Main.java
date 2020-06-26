package p2495;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			var nums = sc.next().split("");
			sb.append(check(nums) + "\n");
		}
		System.out.println(sb.toString());
	}

	private static int check(String[] nums) {
		var arr = new int[8][10];
		for (int i = 0; i < 8; i++) {
			arr[i][Integer.parseInt(nums[i])] = 1;
		}

		for (int i = 0; i < 10; i++) {
			var c = 0;
			for (int j = 0; j < 8; j++) {
				if (arr[j][i] == 1) {
					arr[j][i] = ++c;
				} else {
					c = 0;
				}
			}
		}

		var k = 1;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 10; j++) {
				k = Math.max(k, arr[i][j]);
			}
		}

		return k;
	}
}