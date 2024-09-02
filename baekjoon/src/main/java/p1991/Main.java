package p1991;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 제목 : 트리 순회
 * 링크 : https://www.acmicpc.net/problem/1991
 * 분류 : 트리 (전위 순회, 중위 순회, 후위 순회)
 */
public class Main {

    static Map<String, Node> nodes = new HashMap();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String a = sc.next();
            String b = sc.next();
            String c = sc.next();
            nodes.put(a, new Node(b, c));
        }
        preOrder("A");
        System.out.println();
        inOrder("A");
        System.out.println();
        postOrder("A");
    }

    private static void preOrder(String node) {
        if (node.equals(".")) return;
        System.out.print(node);
        preOrder(nodes.get(node).left);
        preOrder(nodes.get(node).right);
    }

    private static void inOrder(String node) {
        if (node.equals(".")) return;
        inOrder(nodes.get(node).left);
        System.out.print(node);
        inOrder(nodes.get(node).right);
    }

    private static void postOrder(String node) {
        if (node.equals(".")) return;
        postOrder(nodes.get(node).left);
        postOrder(nodes.get(node).right);
        System.out.print(node);
    }
}

class Node {
    String left;
    String right;

    public Node(String left, String right) {
        this.left = left;
        this.right = right;
    }
}