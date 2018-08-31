package linkedList;

public class SingleLinkedNode {
    private int data;
    private SingleLinkedNode next;

    public SingleLinkedNode() {
        next = null;
        data = 0;
    }

    public SingleLinkedNode(int data) {
        this.data = data;
        this.next = null;
    }

    public SingleLinkedNode(int data, SingleLinkedNode singleLinkedNode) {
        this.data = data;
        this.next = singleLinkedNode;
    }

    public void setNext(SingleLinkedNode singleLinkedNode) {
        this.next = singleLinkedNode;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public SingleLinkedNode next() {
        return next;
    }

    public String toString() {
        return String.valueOf(data);
    }
}
