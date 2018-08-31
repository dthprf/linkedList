package linkedList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    private DoublyLinkedList generateList(int noElements) {
        DoublyLinkedList linkedList = new DoublyLinkedList();

        for (int i = 0; i < noElements; i++) {
            linkedList.add(i);
        }

        return linkedList;
    }

    @Test
    void testAddWithNoIndex() {
        DoublyLinkedList linkedList = generateList(1);
        assertEquals("[0]", linkedList.toString());
        assertEquals(0, linkedList.end().getData());
        assertEquals(null, linkedList.head().next());
        linkedList.add(1);
        assertEquals("[0, 1]", linkedList.toString());
        assertEquals(1, linkedList.end().getData());
        assertEquals(1, linkedList.head().next().getData());
        linkedList.add(2);
        assertEquals("[0, 1, 2]", linkedList.toString());
        assertEquals(2, linkedList.end().getData());
        assertEquals(1, linkedList.head().next().getData());
        assertEquals(0, linkedList.head().getData());
        assertEquals(1, linkedList.end().previous().getData());
        assertEquals(null, linkedList.head().previous());
    }

    @Test
    void testAddWithIndex() {
        DoublyLinkedList linkedList = generateList(3);
        linkedList.add(100, 0);
        linkedList.add(500, 4);
        linkedList.add(1000, 2);
        String prevLinkTestResult = "[500, 2, 1, 1000, 0, 100]";
        String result = "[100, 0, 1000, 1, 2, 500]";
        assertEquals(result, linkedList.toString());
        assertEquals(prevLinkTestResult, testPreviousLink(linkedList));
        assertEquals(6, linkedList.length());
    }

    @Test
    void testIncorrectIndex() {
        DoublyLinkedList linkedList = generateList(3);
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add(33,5));
    }

    @Test
    void testRemove() {
        DoublyLinkedList linkedList = generateList(10);
        linkedList.remove(0);
        linkedList.remove(3);
        linkedList.remove(7);
        String result = "[1, 2, 3, 5, 6, 7, 8]";
        String prevLinkTestResult = "[8, 7, 6, 5, 3, 2, 1]";
        assertEquals(result, linkedList.toString());
        assertEquals(prevLinkTestResult, testPreviousLink(linkedList));
        assertEquals(7, linkedList.length());
        assertEquals(1, linkedList.head().getData());
        assertEquals(8, linkedList.end().getData());
    }

    private String testNextLinks(DoublyLinkedList linkedList) {
        StringBuilder sb = new StringBuilder("[");
        DoublyLinkedNode temp = linkedList.head();

        while (temp != null) {
            sb.append(temp);

            if (temp.next() != null) {
                sb.append(", ");
            }

            temp = temp.next();
        }

        sb.append("]");
        return sb.toString();
    }

    private String testPreviousLink(DoublyLinkedList linkedList) {
        StringBuilder sb = new StringBuilder("[");
        DoublyLinkedNode temp = linkedList.end();

        while (temp != null) {
            sb.append(temp);

            if (temp.previous() != null) {
                sb.append(", ");
            }

            temp = temp.previous();
        }

        sb.append("]");
        return sb.toString();
    }
}