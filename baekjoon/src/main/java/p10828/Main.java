package p10828;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack stack = new Stack();
		for (int i = 0; i < n; i++) {
			String m = sc.next();
			if (m.equals("push")) {
				stack.push(sc.nextInt());
			}
			if (m.equals("pop")) {
				System.out.println(stack.pop());
			}
			if (m.equals("size")) {
				System.out.println(stack.size());
			}
			if (m.equals("empty")) {
				System.out.println(stack.isEmpty());
			}
			if (m.equals("top")) {
				System.out.println(stack.top());
			}
		}
	}
}

class Stack {

	private int size;
	private Node current;

	public void push(int n) {
		if (isEmpty() == 1) {
			current = new Node(n);
		} else {
			Node node = new Node(n);
			node.setPrevNode(current);
			current = node;
		}
		size++;
	}

	public int pop() {
		if (current == null) {
			return -1;
		} else {
			int value = current.getValue();
			current = current.getPrevNode();
			size--;
			return value;
		}
	}

	public int size() {
		return size;
	}

	public int isEmpty() {
		return size == 0 ? 1 : 0;
	}

	public int top() {
		if (current == null) {
			return -1;
		} else {
			return current.getValue();
		}
	}
}

class Node {
	private Node prevNode;
	private int value;

	public Node(int value) {
		this.value = value;
	}

	public Node getPrevNode() {
		return prevNode;
	}

	public Node setPrevNode(Node node) {
		return prevNode = node;
	}

	public int getValue() {
		return value;
	}
}