package linkedList;

public class App {
    public static void main( String[] args ) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(11);
        doublyLinkedList.add(12);
        doublyLinkedList.add(13);
        doublyLinkedList.add(100, 0);
        doublyLinkedList.add(200, 1);
        System.out.println(doublyLinkedList);
        System.out.println(testPreviousLink(doublyLinkedList));
    }

    private static String testPreviousLink(DoublyLinkedList linkedList) {
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
