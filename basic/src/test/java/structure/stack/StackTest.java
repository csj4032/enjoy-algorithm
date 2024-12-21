package structure.stack;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
public class StackTest {

    @Test
    @Order(1)
    public void createTest() {
        Stack stack = new Stack();
        assertNotNull(stack);
    }

    @Test
    @Order(2)
    public void pushTest() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    @Test
    @Order(3)
    public void popTest() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(1);
        stack.push(5);
        stack.pop();
    }

    @Test
    @Order(3)
    public void peekTest() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(1);
        stack.push(5);
        stack.head();
    }
}