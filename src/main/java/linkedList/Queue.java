package linkedList;

public class Queue {
    private QueueNode head;
    private QueueNode end;
    private int size;

    public Queue() {
        head = null;
        end = null;
        size = 0;
    }

    public void enqueue(String value, Integer priority) {
        QueueNode current = new QueueNode(value, priority);

        if (size == 0) {
            head = current;
            end = current;

        } else if (head.comparePriority(current) < 1) {
            insertAsHead(current);

        } else if (end.comparePriority(current) > 0) {
            insertAsEnd(current);

        } else {
            QueueNode previous = findPreviousNode(current);
            QueueNode temp = previous.getNextNode();
            previous.setNextNode(current);
            current.setNextNode(temp);
        }
        size++;
    }

    public QueueNode peek() {
        if (size == 0) {
            throw new StackUnderFlowException("Queue is empty, nothing to pick");
        }

        return end;
    }

    public QueueNode dequeue() {
        if (size == 0) {
            throw new StackUnderFlowException("Queue is empty, nothing to dequeue");
        }
        QueueNode temp = head;

        while (temp.getNextNode().getNextNode() != null) {
            temp = temp.getNextNode();
        }

        QueueNode lastNode = temp.getNextNode();
        end = temp;
        end.setNextNode(null);

        return lastNode;
    }

    private QueueNode findPreviousNode(QueueNode node) {
        QueueNode current = head;

        while (current.getNextNode().comparePriority(node) > 0) {
            current = current.getNextNode();
        }

        return current;
    }

    private void insertAsHead(QueueNode node) {
        node.setNextNode(this.head);
        head = node;
    }

    private void insertAsEnd(QueueNode node) {
        end.setNextNode(node);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        QueueNode current = head;

        while(current != null) {
            sb.append(current);

            if (current.getNextNode() != null) {
                sb.append(", ");
            }

            current = current.getNextNode();
        }

        sb.append("]");

        return sb.toString();
    }
}
