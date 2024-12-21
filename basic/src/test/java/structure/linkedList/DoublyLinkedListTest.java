package structure.linkedList;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DoublyLinkedListTest {

    @Test
    @Order(1)
    public void createTest() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        assertNotNull(doublyLinkedList);
    }

    @Test
    @Order(2)
    public void firstAddTest() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.firstAdd(1);
        doublyLinkedList.firstAdd(2);
        doublyLinkedList.firstAdd(3);
        doublyLinkedList.print();
    }

    @Test
    @Order(2)
    public void lastAddTest() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.lastAdd(1);
        doublyLinkedList.lastAdd(2);
        doublyLinkedList.lastAdd(3);
        doublyLinkedList.print();
    }
}