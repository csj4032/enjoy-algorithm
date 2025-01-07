package structure.queue;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import structure.StructurePrinter;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DequeTest {

    StructurePrinter<Integer> printer = new StructurePrinter<>();

    @Test
    @Order(1)
    public void addFrontTest() {
        Deque<Integer> deque = new Deque<>();
        deque.addFront(1);
        deque.addFront(2);
        deque.addFront(3);
        printer.print(deque, StructurePrinter.PrintOrder.FIFO);
    }

    @Test
    @Order(2)
    public void addRearTest() {
        Deque<Integer> deque = new Deque<>();
        deque.addRear(1);
        deque.addRear(2);
        deque.addRear(3);
        printer.print(deque, StructurePrinter.PrintOrder.FIFO);
    }

    @Test
    @Order(3)
    public void rearPeekTest() {
        Deque<Integer> deque = new Deque<>();
        deque.addRear(1);
        deque.addRear(2);
        deque.addRear(3);
        assertEquals(3, deque.peekRear());
        assertEquals(3, deque.size());
    }

    @Test
    @Order(4)
    public void frontPeekTest() {
        Deque<Integer> deque = new Deque<>();
        deque.addRear(1);
        deque.addRear(2);
        deque.addRear(3);
        assertEquals(1, deque.peekFront());
        assertEquals(3, deque.size());
    }

    @Test
    @Order(5)
    public void frontRemoveTest() {
        Deque<Integer> deque = new Deque<>();
        deque.addRear(1);
        deque.addRear(2);
        deque.addRear(3);
        assertEquals(1, deque.removeFront());
        assertEquals(2, deque.size());
    }

    @Test
    @Order(6)
    public void rearRemoveTest() {
        Deque<Integer> deque = new Deque<>();
        deque.addRear(1);
        deque.addRear(2);
        deque.addRear(3);
        assertEquals(3, deque.removeRear());
        assertEquals(2, deque.size());
    }

    @Test
    @Order(7)
    public void frontRearTest() {
        Deque<Integer> deque = new Deque<>();
        deque.addRear(1);
        deque.addFront(2);
        deque.addRear(3);
        deque.addFront(4);
        assertEquals(4, deque.size());
        printer.print(deque, StructurePrinter.PrintOrder.FIFO);
    }

    @Test
    @Order(8)
    public void frontRearRemoveTest() {
        Deque<Integer> deque = new Deque<>();
        deque.addRear(1);
        deque.addFront(2);
        deque.addRear(3);
        deque.addFront(4);
        assertEquals(4, deque.size());
        deque.removeRear();
        deque.removeFront();
        assertEquals(1, deque.removeRear());
        printer.print(deque, StructurePrinter.PrintOrder.FIFO);
    }

    @Test
    @Order(10)
    public void throwsTest() {
        assertDoesNotThrow(() -> {
            Deque<Integer> deque = new Deque<>();
            deque.addRear(1);
        });

        assertThrows(IllegalStateException.class, () -> {
            Deque<Integer> deque = new Deque<>();
            deque.addRear(1);
            deque.addRear(2);
            deque.removeFront();
            deque.removeRear();
            deque.peekRear();
        });
    }
}