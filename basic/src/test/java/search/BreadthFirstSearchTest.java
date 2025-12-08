package search;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BreadthFirstSearchTest {

    @Test
    @Order(1)
    public void breadthFirstSearchTest() {
        Graph graph = new Graph(6);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);

        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
        breadthFirstSearch.bfs(graph, 1);

        //BreadthFirstSearch: 1 2 3 4 5 6
    }
}