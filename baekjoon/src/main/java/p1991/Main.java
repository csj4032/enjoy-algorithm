package p1991;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Node root;
		for (int i = 0; i < n; i++) {
			Node node = new Node(sc.next());
			node.right = new Node(sc.next());
			node.left = new Node(sc.next());
		}
	}
}

class Node {
	public Node left;
	public Node right;
	public String value;
	public Node(String value) {
		this.value = value;
	}
}
