package linkedList;

public class DoublyLinkedNode {
    private DoublyLinkedNode next;
    private DoublyLinkedNode previous;
    private int data;

    public DoublyLinkedNode(int data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(DoublyLinkedNode next) {
        this.next = next;
    }

    public DoublyLinkedNode next() {
        return next;
    }

    public void setPrevious(DoublyLinkedNode previous) {
        this.previous = previous;
    }

    public DoublyLinkedNode previous() {
        return previous;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
