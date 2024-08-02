package p10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack stack = new Stack();
        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");
            if (command[0].equals("push")) {
                stack.push(Integer.parseInt(command[1]));
            }
            if (command[0].equals("pop")) {
                System.out.println(stack.pop());
            }
            if (command[0].equals("size")) {
                System.out.println(stack.size());
            }
            if (command[0].equals("empty")) {
                System.out.println(stack.isEmpty());
            }
            if (command[0].equals("top")) {
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
    private final int value;

    public Node(int value) {
        this.value = value;
    }

    public Node getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(Node node) {
        prevNode = node;
    }

    public int getValue() {
        return value;
    }
}