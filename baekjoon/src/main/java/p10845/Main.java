package p10845;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue queue = new Queue();
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			if (str.equals("push")) {
				queue.push(sc.nextInt());
			}
			if (str.equals("front")) {
				System.out.println(queue.front());
			}
			if (str.equals("back")) {
				System.out.println(queue.back());
			}
			if (str.equals("size")) {
				System.out.println(queue.size());
			}
			if (str.equals("pop")) {
				System.out.println(queue.pop());
			}
			if (str.equals("empty")) {
				System.out.println(queue.isEmpty());
			}
		}
	}
}

class Queue {
	private int size;
	private Node current;
	private Node first;

	public void push(int x) {
		if (isEmpty() == 1) {
			first = new Node(null, null, x);
			current = first;
		} else {
			Node node = new Node(current, null, x);
			current.setNext(node);
			current = node;
		}
		size++;
	}

	public int pop() {
		if (first == null) return -1;
		int value = first.getValue();
		first = first.getNext();
		if (first == null) current = null;
		size--;
		return value;
	}

	public int size() {
		return size;
	}

	public int isEmpty() {
		return size == 0 ? 1 : 0;
	}

	public int front() {
		return first == null ? -1 : first.getValue();
	}

	public int back() {
		return current == null ? -1 : current.getValue();
	}
}

class Node {
	private Node prev;
	private Node next;
	private int value;

	public Node(Node prev, Node next, int value) {
		this.prev = prev;
		this.next = next;
		this.value = value;
	}

	public Node getNext() {
		return this.next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getValue() {
		return value;
	}
}