package search;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    public void bfs(Graph graph, int start) {
        boolean[] visited = new boolean[graph.getSize() + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        System.out.print("BreadthFirstSearch: ");
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");
            for (int next : graph.getNeighbors(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
