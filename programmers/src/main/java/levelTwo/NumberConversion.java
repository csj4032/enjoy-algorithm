package levelTwo;

import java.util.LinkedList;
import java.util.Queue;

public class NumberConversion {

    public static class Node {
        public int value;
        public int count;

        public Node(int value, int count) {
            this.value = value;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Node{" + "value=" + value + ", count=" + count + '}';
        }
    }

    public int solution(int x, int y, int n) {
        int answer = -1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, 0));
        boolean[] visited = new boolean[10000000];
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (y == node.value) {
                answer = node.count;
                break;
            }
            for (int i = 0; i < 3; i++) {
                int newValue = 0;
                if (i == 0) newValue = node.value * 3;
                if (i == 1) newValue = node.value * 2;
                if (i == 2) newValue = node.value + n;
                if ((y * 3) >= newValue && !visited[newValue]) {
                    visited[newValue] = true;
                    queue.add(new Node(newValue, node.count + 1));
                }
            }
            System.out.println(queue);
        }
        return answer;
    }
}
