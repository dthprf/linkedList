package linkedList;

public class DoublyLinkedList {
    private DoublyLinkedNode head;
    private DoublyLinkedNode end;
    private int size;

    public DoublyLinkedList() {
        head = null;
        end = null;
        size = 0;
    }

    public void add(int data) {
        DoublyLinkedNode listNode = new DoublyLinkedNode(data);

        if (size == 0) {
            head = listNode;
            end = listNode;

        } else {
            DoublyLinkedNode temp = end;
            temp.setNext(listNode);
            listNode.setPrevious(temp);
            end = listNode;
        }
        size++;
    }

    public void add(int data, int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("The index [" + index + "] is greater than list size.");

        } else if (index == size) {
            add(data);

        } else if (index == 0) {
            DoublyLinkedNode listNode = new DoublyLinkedNode(data);

            DoublyLinkedNode temp = head;
            listNode.setNext(temp);
            temp.setPrevious(listNode);
            head = listNode;
            size++;

        } else {
            DoublyLinkedNode listNode = new DoublyLinkedNode(data);

            DoublyLinkedNode temp = get(index);
            DoublyLinkedNode prev = temp.previous();
            prev.setNext(listNode);
            listNode.setNext(temp);
            temp.setPrevious(listNode);
            listNode.setPrevious(prev);
            size++;
        }
    }

    public void remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("The index [" + index + "] is greater than list size.");

        } else if (index == 0) {
            DoublyLinkedNode temp = head;
            DoublyLinkedNode newHead = head.next();
            newHead.setPrevious(null);
            temp.setNext(null);
            head = newHead;

        } else if (index == size - 1) {
            DoublyLinkedNode temp = end;
            DoublyLinkedNode newEnd = end.previous();
            newEnd.setNext(null);
            temp.setPrevious(null);
            end = newEnd;

        } else {
            DoublyLinkedNode itemToRemove = get(index);
            DoublyLinkedNode prev = itemToRemove.previous();
            DoublyLinkedNode next = itemToRemove.next();
            next.setPrevious(prev);
            prev.setNext(next);
            itemToRemove.setNext(null);
            itemToRemove.setPrevious(null);
        }
        size--;
    }

    public DoublyLinkedNode get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("The index [" + index + "] is greater than list size.");
        }

        DoublyLinkedNode temp = head;
        int counter = 0;

        while (counter != index) {
            temp = temp.next();
            counter++;
        }

        return temp;
    }

    public DoublyLinkedNode head() {
        return head;
    }

    public DoublyLinkedNode end() {
        return end;
    }

    public int length() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        DoublyLinkedNode temp = head;

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
}
