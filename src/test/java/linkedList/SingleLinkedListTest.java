package linkedList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SingleLinkedListTest {
    private SingleLinkedList createSingleLinkList(int elements) {
        SingleLinkedList sll = new SingleLinkedList();

        for (int i = 0; i < elements; i++) {
            sll.add(i);
        }

        return sll;
    }

    @Test
    void testGetHead() {
        SingleLinkedList linkedList = createSingleLinkList(2);
        SingleLinkedNode listNode = linkedList.getHead();
        assertEquals(0, listNode.getData());
        assertEquals(1, listNode.next().getData());
        assertEquals(null, listNode.next().next());
    }

    @Test
    void testGetEnd() {
        SingleLinkedList linkedList = createSingleLinkList(2);
        SingleLinkedNode listNode = linkedList.getEnd();
        assertEquals(1, listNode.getData());
        assertEquals(null, listNode.next());
    }

    @Test
    void testAddWithoutIndex() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(1);
        singleLinkedList.add(2);
        singleLinkedList.add(3);

        String result = "[1, 2, 3]";
        assertEquals(result, singleLinkedList.toString());
        assertEquals(3, singleLinkedList.length());
        assertEquals(1, singleLinkedList.getHead().getData());
        assertEquals(3, singleLinkedList.getEnd().getData());
        assertEquals(2, singleLinkedList.getHead().next().getData());
    }

    @Test
    void testAddWithIndex() {
        SingleLinkedList sll = createSingleLinkList(10);
        sll.add(22, 0);
        sll.add(55, 5);
        sll.add(77, 12);

        String result = "[22, 0, 1, 2, 3, 55, 4, 5, 6, 7, 8, 9, 77]";
        assertEquals(result, sll.toString());
        assertEquals(13, sll.length());
        assertEquals(77, sll.getEnd().getData());
        assertEquals(22, sll.getHead().getData());
        assertEquals(0, sll.getHead().next().getData());
    }

    @Test
    void testAddIndexLargerThanSize() {
        SingleLinkedList sll = createSingleLinkList(3);
        assertThrows(IndexOutOfBoundsException.class, () -> sll.add(33,4));
    }

    @Test
    void testGet() {
        SingleLinkedList linkedList = createSingleLinkList(5);
        assertEquals(1, linkedList.get(1).getData());
        assertEquals(0, linkedList.get(0).getData());
        assertEquals(4, linkedList.get(4).getData());
    }


    @Test
    void testGetIndexHigherThanSize() {
        SingleLinkedList linkedList = createSingleLinkList(5);
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(5));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(8));
    }

    @Test
    void testRemove() {
        SingleLinkedList linkedList = createSingleLinkList(5);
        linkedList.remove(4);
        linkedList.remove(0);
        String result = "[1, 2, 3]";
        assertEquals(result, linkedList.toString());
        assertEquals(3, linkedList.length());
        assertEquals(1, linkedList.getHead().getData());
        assertEquals(2, linkedList.getHead().next().getData());
        assertEquals(3, linkedList.getEnd().getData());
        assertEquals(null, linkedList.getEnd().next());
    }

    @Test
    void removeOnlyElement() {
        SingleLinkedList linkedList = createSingleLinkList(1);
        linkedList.remove(0);
        String result = "[]";
        assertEquals(result, linkedList.toString());
        assertEquals(0, linkedList.length());
        assertEquals(null, linkedList.getHead());
        assertEquals(null, linkedList.getEnd());
    }

    @Test
    void removeWithWrongIndex() {
        SingleLinkedList linkedList = createSingleLinkList(10);
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(10));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(100));
    }

    @Test
    void replaceTest() {
        SingleLinkedList linkedList = createSingleLinkList(3);
        linkedList.replace(0, 11);
        String result = "[11, 1, 2]";
        assertEquals(result, linkedList.toString());
    }

    @Test
    void replaceTestWrongIndex() {
        SingleLinkedList linkedList = createSingleLinkList(3);
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.replace(10, 11));
    }

}