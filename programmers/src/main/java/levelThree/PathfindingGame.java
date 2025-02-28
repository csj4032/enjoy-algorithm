package levelThree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathfindingGame {

    public static class Node implements Comparable<Node> {
        public int x;
        public int y;
        public int index;
        public Node left;
        public Node right;

        public Node(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.y, y);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", x=" + x +
                    ", y=" + y +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public int[][] solution(int[][] nodeinfo) {
        Queue<Node> queue = new PriorityQueue<>();
        for (int i = 0; i < nodeinfo.length; i++) queue.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
        Node root = queue.poll();
        while (!queue.isEmpty() && root != null) insertNode(root, queue.poll());
        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        preOrder(root, pre);
        postOrder(root, post);
        return new int[][]{pre.stream().mapToInt(Integer::intValue).toArray(), post.stream().mapToInt(Integer::intValue).toArray()};
    }

    private void preOrder(Node node, List<Integer> result) {
        if (node != null) {
            result.add(node.index);
            preOrder(node.left, result);
            preOrder(node.right, result);
        }
    }

    private void postOrder(Node node, List<Integer> result) {
        if (node != null) {
            postOrder(node.left, result);
            postOrder(node.right, result);
            result.add(node.index);
        }
    }

    private void insertNode(Node parent, Node child) {
        if (parent.x > child.x && parent.left == null) {
            parent.left = child;
            return;
        }
        if (parent.x < child.x && parent.right == null) {
            parent.right = child;
            return;
        }
        if (parent.x > child.x) insertNode(parent.left, child);
        if (parent.x < child.x) insertNode(parent.right, child);
    }
}
