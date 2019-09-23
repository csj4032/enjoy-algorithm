package p11279;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 제목 : 최대 힙
 * 링크 : https://www.acmicpc.net/problem/11279
 * 분류 : 힙
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		PriorityQueue<Long> priorityQueue = new PriorityQueue(Comparator.reverseOrder());
		for (int i = 0; i < n; i++) {
			Long l = sc.nextLong();
			if (l != 0) {
				priorityQueue.add(l);
			} else {
				if (priorityQueue.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(priorityQueue.poll()).append("\n");
				}
			}
		}
		System.out.println(sb.toString());
	}
}
