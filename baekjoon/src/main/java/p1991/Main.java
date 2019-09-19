package p1991;

import java.util.Scanner;

/**
 * 제목 : 트리 순회
 * 링크 : https://www.acmicpc.net/problem/1991
 * 분류 : 트리
 */
public class Main {

	static String[] node = new String[1000];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		node[1] = "A";
		for (int i = 0; i < n; i++) {
			String a = sc.next();
			String b = sc.next();
			String c = sc.next();
			int parent = search(a);
			node[parent * 2] = b;
			node[parent * 2 + 1] = c;
		}
		preOrder(1);
		System.out.println("");
		inOrder(1);
		System.out.println("");
		postOrder(1);
	}

	private static void preOrder(int i) {
		if (node[i].equals(".")) return;
		System.out.print(node[i]);
		preOrder(i * 2);
		preOrder(i * 2 + 1);
	}

	private static void inOrder(int i) {
		if (node[i].equals(".")) return;
		inOrder(i * 2);
		System.out.print(node[i]);
		inOrder(i * 2 + 1);
	}

	private static void postOrder(int i) {
		if (node[i].equals(".")) return;
		postOrder(i * 2);
		postOrder(i * 2 + 1);
		System.out.print(node[i]);
	}

	private static int search(String a) {
		int i = 1;
		while (i < node.length) {
			if (a.equals(node[i])) {
				break;
			}
			i++;
		}
		return i;
	}
}