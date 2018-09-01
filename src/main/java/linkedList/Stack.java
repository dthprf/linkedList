package linkedList;

public class Stack <E> {
    private int capacity;
    private int size;
    private Object[] elements;

    public Stack(int size) {
        this.capacity = size;
        this.size = 0;
        elements = new Object[size];
    }

    public void push(E element) {
        if (size == capacity) {
            throw new StackOverflowException("Capacity of the stack has been reach");
        }
        elements[size++] = element;
    }

    public E pop() {
        if (size == 0) {
            throw new StackUnderFlowException("Stack is empty");
        }
        E e = (E) elements[--size];
        elements[size] = null;

        return e;
    }

    public E peek() {
        if (size == 0) {
            throw new StackUnderFlowException("Stack is empty");
        }
        return (E) elements[size - 1];
    }

    public int getCapacity() {
        return capacity;
    }

    public int getAvailableSpace() {
        return capacity - size;
    }

    public int length() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i = 0; i < size ;i++) {
            sb.append(elements[i].toString());

            if(i < size - 1){
                sb.append(", ");
            }
        }

        sb.append(']');
        return sb.toString();
    }
}
