package search;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DepthFirstSearchTest {

    @Test
    @Order(1)
    public void depthFirstSearchTest() {
        Graph graph = new Graph(6);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        System.out.println(graph.toString());
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        depthFirstSearch.dfs(graph, 1);

        // DFS 탐색 순서: 1 2 4 5 3 6
    }
}