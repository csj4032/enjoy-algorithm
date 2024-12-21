package structure.queue;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import structure.StructurePrinter;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class QueueTest {

    StructurePrinter<Integer> printer = new StructurePrinter<>();

    @Test
    @Order(1)
    public void createTest() {
        Queue<Integer> queue = new Queue<>();
        assertNotNull(queue);
    }

    @Test
    @Order(2)
    public void enqueueTest() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
    }

    @Test
    @Order(3)
    public void dequeueTest() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        printer.print(queue, StructurePrinter.PrintOrder.FIFO);
    }
}