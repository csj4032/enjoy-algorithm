package p11003;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var l = sc.nextInt();
		var queue = new LinkedList<Integer>();
		var sb = new StringBuilder();
		var min = Integer.MAX_VALUE;
		for (int i = 0; i < l - 1; i++) queue.add(Integer.MAX_VALUE);
		for (int i = 0; i < n; i++) {
			var k = sc.nextInt();
			min = Math.min(k, queue.peek());
			queue.add(min);
			sb.append(min + " ");
			if(queue.peek() == min) {

			}
		}
		System.out.println(sb.toString());
	}
}
