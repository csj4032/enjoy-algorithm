package challenge.fortyTwoDot;

import java.util.*;

public class Problem2 {

    public long solution(int[][] parking) {
        long answer = 0;

        Node[] nodes = new Node[parking.length];
        for (int i = 0; i < parking.length; i++) nodes[i] = new Node(i);

        for (int i = 0; i < parking.length; i++) {
            for (int j = 0; j < parking[i].length; j++) {
                if (parking[i][j] != -1) {
                    nodes[i].neighbors.add(nodes[parking[i][j]]);
                }
            }
        }

        for (int i = 0; i < nodes.length; i++) {
            for (int j = i + 1; j < nodes.length; j++) {
                if (check(nodes, i, j)) {
                    answer++;
                }
            }
        }
        return answer;
    }

    private boolean check(Node[] nodes, int start, int target) {
        boolean[] visited = new boolean[nodes.length];
        Map<Integer, Integer> parentMap = new HashMap<>();
        Stack<Node> stack = new Stack<>();

        stack.push(nodes[start]);
        visited[start] = true;
        parentMap.put(start, -1);
        while (!stack.isEmpty()) {
            Node current = stack.pop();

            for (Node neighbor : current.neighbors) {
                if (!visited[neighbor.id]) {
                    visited[neighbor.id] = true;
                    parentMap.put(neighbor.id, current.id);
                    stack.push(neighbor);
                    if (neighbor.id == target) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        int[][] arr = {{1, 2}, {3, 4}, {-1, -1}, {-1, -1}, {-1, -1}};
        //int[][] arr = {{1, 2}, {3, 4}, {5, 6}, {-1, 7}, {8, 9}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}};
        System.out.println(problem2.solution(arr));
    }
}


class Node {
    int id;
    List<Node> neighbors;

    Node(int id) {
        this.id = id;
        this.neighbors = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Node{" + "id=" + id + "}";
    }
}
