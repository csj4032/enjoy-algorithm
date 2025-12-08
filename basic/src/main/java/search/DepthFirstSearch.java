package search;

public class DepthFirstSearch {

    public void dfs(Graph graph, int start) {
        System.out.print("DFS 탐색 순서: ");
        boolean[] visited = new boolean[graph.getSize() + 1];
        recursive(graph, start, visited);
    }

    private void recursive(Graph graph, int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int next : graph.getNeighbors(node)) {
            if (!visited[next]) {
                recursive(graph, next, visited);
            }
        }
    }
}