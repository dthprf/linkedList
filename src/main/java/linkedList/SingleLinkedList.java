package linkedList;

public class SingleLinkedList {
    private SingleLinkedNode head;
    private SingleLinkedNode end;
    private int size;

    public SingleLinkedList() {
        head = null;
        end = null;
        size = 0;
    }

    public void add(int data, int index) {

        if (index > size) {
            throw new IndexOutOfBoundsException("The index [" + index + "] is greater than list size.");
        }

        SingleLinkedNode listNode = new SingleLinkedNode(data);
        SingleLinkedNode current = head;

        if (index == 0) {
            listNode.setNext(head);
            this.head = listNode;

        } else {

            for (int i = 1; i < index; i++) {
                current = current.next();
            }

            listNode.setNext(current.next());
            current.setNext(listNode);
        }

        if (index == size) {
            this.end = listNode;
        }
        this.size++;
    }

    public void add(int data) {
        add(data, size);
    }

    public void replace(int index, int data) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("The index [" + index + "] is greater than list size.");
        }
        SingleLinkedNode listNode = get(index);
        listNode.setData(data);
    }

    public SingleLinkedNode get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("The index [" + index + "] is greater than list size.");
        }

        SingleLinkedNode temp = head;
        int counter = 0;

        while (counter != index) {
            temp = temp.next();
            counter++;
        }

        return temp;
    }

    public void remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("The index [" + index + "] is greater than list size.");

        }else if (size == 1) {
            head = null;
            end = null;
            size--;

        } else if (index == 0) {
            head = head.next();
            size--;

        } else if (index == size -1) {
            SingleLinkedNode listNode = get(index - 1);
            listNode.setNext(null);
            end = listNode;
            size--;

        } else {
            SingleLinkedNode current = head.next();
            SingleLinkedNode previous = head;
            int counter = 1;

            while (counter != index) {
                current = current.next();
                previous = previous.next();
                counter++;
            }

            previous.setNext(current.next());
            size--;
        }
    }

    public SingleLinkedNode getHead() {
        return head;
    }

    public SingleLinkedNode getTail() {
        return head.next();
    }

    public void setHead(SingleLinkedNode head) {
        this.head = head;
    }

    public SingleLinkedNode getEnd() {
        return end;
    }

    public int length() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        SingleLinkedNode temp = head;

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
