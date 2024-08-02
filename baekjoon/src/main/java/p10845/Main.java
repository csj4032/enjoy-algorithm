package p10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue queue = new Queue();
		for (int i = 0; i < n; i++) {
			String[] command = br.readLine().split(" ");
			if (command[0].equals("push")) {
				queue.push(Integer.parseInt(command[1]));
			}
			if (command[0].equals("front")) {
				System.out.println(queue.front());
			}
			if (command[0].equals("back")) {
				System.out.println(queue.back());
			}
			if (command[0].equals("size")) {
				System.out.println(queue.size());
			}
			if (command[0].equals("pop")) {
				System.out.println(queue.pop());
			}
			if (command[0].equals("empty")) {
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