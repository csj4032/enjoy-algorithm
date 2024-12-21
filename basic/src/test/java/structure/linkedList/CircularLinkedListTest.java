package structure.linkedList;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CircularLinkedListTest {

    @Test
    @Order(1)
    public void createTest() {
        CircularLinkedList<Integer> circularLinkedList = new CircularLinkedList<>();
        assertNotNull(circularLinkedList);
    }

    @Test
    @Order(2)
    public void appendTest() {
        CircularLinkedList<Integer> circularLinkedList = new CircularLinkedList<>();
        circularLinkedList.add(1);
        circularLinkedList.add(2);
        circularLinkedList.add(3);
        circularLinkedList.print();
    }
}