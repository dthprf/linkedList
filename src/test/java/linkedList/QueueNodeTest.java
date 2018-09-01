package linkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueNodeTest {

    @Test
    void testPriorityComparator() {
        QueueNode nodeNull = new QueueNode("one", null);
        QueueNode nodeZero = new QueueNode("two", 0);
        QueueNode nodeOne = new QueueNode("one", 1);
        QueueNode nodeNull2 = new QueueNode("two", null);

        assertEquals(0, nodeNull.comparePriority(nodeNull2));
        assertEquals(1, nodeOne.comparePriority(nodeNull));
        assertEquals(1, nodeOne.comparePriority(nodeZero));
        assertEquals(0, nodeZero.comparePriority(nodeZero));
        assertEquals(-1, nodeNull.comparePriority(nodeZero));
        assertEquals(-1, nodeNull.comparePriority(nodeOne));
        assertEquals(-1, nodeZero.comparePriority(nodeOne));
    }

}