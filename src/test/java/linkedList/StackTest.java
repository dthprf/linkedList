package linkedList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void testStackZeroSize() {
        Stack<Integer> integersStack = new Stack<>(0);
        assertEquals(0, integersStack.getCapacity());
        assertEquals(0, integersStack.getAvailableSpace());
        assertEquals(0, integersStack.length());
        assertEquals("[]", integersStack.toString());
    }

    @Test
    void testStackWithCapacity() {
        Stack<String> stringStack = new Stack<>(3);
        assertEquals(3, stringStack.getCapacity());
        assertEquals(3, stringStack.getAvailableSpace());
        assertEquals(0, stringStack.length());
        assertEquals("[]", stringStack.toString());
    }

    @Test
    void testPush() {
        Stack<Integer> integersStack = new Stack<>(5);
        integersStack.push(1);
        assertEquals(5, integersStack.getCapacity());
        assertEquals(4, integersStack.getAvailableSpace());
        assertEquals(1, integersStack.length());
        assertEquals("[1]", integersStack.toString());

        integersStack.push(2);
        integersStack.push(3);
        assertEquals(5, integersStack.getCapacity());
        assertEquals(2, integersStack.getAvailableSpace());
        assertEquals(3, integersStack.length());
        assertEquals("[1, 2, 3]", integersStack.toString());

        integersStack.push(4);
        integersStack.push(5);
        assertThrows(StackOverflowException.class, () -> integersStack.push(6));
    }

    @Test
    void testPop() {
        Stack<Integer> integersStack = new Stack<>(5);
        assertThrows(StackUnderFlowException.class, () -> integersStack.pop());
        integersStack.push(1);
        assertEquals((Integer) 1, integersStack.pop());
        assertEquals(0, integersStack.length());
        assertEquals(5, integersStack.getAvailableSpace());
        assertEquals(0, integersStack.length());

        integersStack.push(2);
        integersStack.push(3);
        integersStack.push(4);
        assertEquals((Integer) 4, integersStack.pop());
        assertEquals((Integer) 3, integersStack.pop());
        assertEquals(1, integersStack.length());
        assertEquals(4, integersStack.getAvailableSpace());
        assertEquals("[2]", integersStack.toString());
    }

    @Test
    void testPeek() {
        Stack<Integer> integersStack = new Stack<>(5);
        assertThrows(StackUnderFlowException.class, () -> integersStack.peek());
        integersStack.push(1);
        assertEquals((Integer) 1, integersStack.peek());
        integersStack.push(2);
        integersStack.push(3);
        assertEquals((Integer) 3, integersStack.peek());
    }
}