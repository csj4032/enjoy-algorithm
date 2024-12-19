package structure.linkedList;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SinglyLinkedListTest {

    @Test
    @Order(1)
    public void createTest() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        assertNotNull(singlyLinkedList);
    }

    @Test
    @Order(2)
    public void appendTest() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);
        singlyLinkedList.print();
    }

    @Test
    @Order(3)
    public void searchTest() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);
        singlyLinkedList.add(4);
        singlyLinkedList.add(5);
        singlyLinkedList.add(6);
        singlyLinkedList.remove(2);
        assertEquals(4, singlyLinkedList.get(2).value);
        singlyLinkedList.print();
    }

    @Test
    @Order(4)
    public void removeTest() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);
        singlyLinkedList.remove(0);
        assertEquals(2, singlyLinkedList.size());
        singlyLinkedList.add(4);
        assertEquals(3, singlyLinkedList.size());
        singlyLinkedList.print();

        System.out.println("\nRequesting GC...");
        System.gc();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}