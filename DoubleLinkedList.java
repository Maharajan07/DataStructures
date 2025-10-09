class Node {
    int data;
    Node next;
    Node prev;

    Node (int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoubleLinkedList {
    private Node head;

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;

        System.out.println("Inserted " + data + " at Beginning!");
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            System.out.println("Inserted " + data + " successfully!");
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;

        System.out.println("Inserted " + data + " successfully!");
    }

    public void insertAtIndex(int index, int value) {
        if (index < 0) {
            System.out.println("Can't insert: Invalid index");
            return;
        }

        if (index == 0) {
            insertAtBeginning(value);
            return;
        }

        Node temp = head;
        for  (int i=0; temp != null && i<index-1; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Can't insert: Invalid index");
            return;
        }

        Node newNode = new Node(value);
        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;
    }

    public void deleteAtValue(int value) {
        if (head == null) {
            System.out.println("Can't delete: List is null");
            return;
        }

        Node temp = head;
        while (temp != null && temp.data != value) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Can't delete: Value " + value + "not found");
            return;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
        else {
            head = temp.next;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        System.out.println("Deleted value " + value);
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || head == null) {
            System.out.println("Can't delete: Invalid index");
            return;
        }

        Node temp = head;
        for (int i=0; temp != null && i<index; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Can't delete: Index " + index + " not found");
            return;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
        else {
            head = temp.next;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        System.out.println("Deleted value at index " + index);
    }

    public boolean search(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == value) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void reverse() {
        if (head == null) return;

        Node current = head;
        Node temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            current = current.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
    }

    public int size() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void display() {
        Node temp = head;
        System.out.print("List: null <-> ");

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }


    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();

        list.insertAtBeginning(4);
        list.insertAtBeginning(3);
        list.insertAtBeginning(2);
        list.insertAtEnd(5);
        list.insertAtIndex(0, 1);
        // list.insertAtIndex(8, 6);

        // list.deleteAtValue(4);

        list.deleteAtIndex(1);

        System.out.println(list.search(8));

        System.out.println("Total size od the LinkedList: " + list.size());

        list.display();
        
        list.reverse();

        list.display();
    }
}
