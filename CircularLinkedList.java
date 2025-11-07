public class CircularLinkedList<T> {
    class Node {
        T data;
        Node next;

        Node (T data) {
            this.data = data;
            this.next = null;
        }
    }

    Node tail;
    CircularLinkedList() {
        tail = null;
    }

    void insertAtBegining(T data) {
        Node newNode = new Node(data);
        
        if (tail == null) {
            newNode.next = newNode;
            tail = newNode;
        }
        else {
            newNode.next = tail.next;
            tail.next = newNode;
        }
        System.out.println(data + " Inserted at Begining!");
    }

    void insertAtEnd(T data) {
        Node newNode = new Node(data);

        if (tail == null) {
            newNode.next = newNode;
            tail = newNode;
        }
        else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        System.out.println(data + " Inserted at the End!");
    }

    void deleteAtBegining() {
        if (tail == null) {
            System.out.println("Nothing deleted: Empty List");
            return;
        }

        if (tail.next == tail) {
            tail = null;
            System.out.println("Data deleted at the Begining!");
            return;
        }
        else {
            tail.next = tail.next.next;
            System.out.println("Data deleted at the Begining!");
        }
    }

    void deleteAtEnd() {
        if (tail == null) {
            System.out.println("Nothing deleted: Empty List");
            return;
        }

        if (tail.next == tail) {
            tail = null;
            System.out.println("Data deleted at the End!");
            return;
        }
        else {
            Node temp = tail.next;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = tail.next;     // or temp.next = temp.next.next
            tail = temp;
            System.out.println("Data deleted at the End!");
        }
    }

    void display() {
        if (tail == null) {
            System.out.println("Circular List: Empty");
            return;
        }

        Node temp = tail.next;
        System.out.print("Circular List: ");

        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != tail.next);
    }

    public static void main(String[] args) {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();

        list.insertAtBegining(5);  // 5 ->
        list.insertAtBegining(1);  // 1 -> 5 ->
        list.insertAtBegining(7);  // 7 -> 1 -> 5 ->

        list.insertAtEnd(2);       // 7 -> 1 -> 5 -> 2 ->

        list.deleteAtBegining();   // 1 -> 5 -> 2 -> 
        list.deleteAtEnd();        // 1 -> 5 ->

        list.display();
    }

}
