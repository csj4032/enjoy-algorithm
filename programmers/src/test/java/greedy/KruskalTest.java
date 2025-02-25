package greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class KruskalTest {

    @Test
    public void tset() {
        Kruskal kruskal = new Kruskal();
        List<Kruskal.Edge> edges = new ArrayList<>();
        edges.add(new Kruskal.Edge(0, 1, 1));
        edges.add(new Kruskal.Edge(0, 2, 3));
        edges.add(new Kruskal.Edge(1, 2, 1));
        edges.add(new Kruskal.Edge(1, 3, 4));
        edges.add(new Kruskal.Edge(2, 3, 2));
        Assertions.assertEquals(4, kruskal.minimumSpanningTree(4, edges));
    }
}