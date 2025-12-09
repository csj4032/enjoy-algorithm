package structure.tree;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import structure.Node;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TraversalTest {

    /**
     *       A
     *      / \
     *     B   C
     *    / \
     *   D   E
     */

    @Test
    @Order(1)
    public void preorderTest() {
        Node root = new Node('A');
        root.prev = new Node('B');
        root.next = new Node('C');
        root.prev.prev = new Node('D');
        root.prev.next = new Node('E');

        Traversal traversal = new Traversal();
        System.out.print("Preorder: ");
        traversal.preorder(root);
    }

    @Test
    @Order(2)
    public void inorderTest() {
        Node root = new Node('A');
        root.prev = new Node('B');
        root.next = new Node('C');
        root.prev.prev = new Node('D');
        root.prev.next = new Node('E');

        Traversal traversal = new Traversal();
        System.out.print("Inorder: ");
        traversal.inorder(root);
    }

    @Test
    @Order(2)
    public void postorderTest() {
        Node root = new Node('A');
        root.prev = new Node('B');
        root.next = new Node('C');
        root.prev.prev = new Node('D');
        root.prev.next = new Node('E');

        Traversal traversal = new Traversal();
        System.out.print("Postorder: ");
        traversal.postorder(root);
    }
}