class Node {
    int data;
    Node next;

    Node (int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    private Node head;

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
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
        System.out.println("Inserted " + data + " at the End!");
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
        Node newNode = new Node(value);
        Node temp = head;
        for (int i=0; temp != null && i<index-1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Can't insert: List is null");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println("Inserted " + value + " at index " + index);
    }
    
    public void deleteByValue(int value) {
        if (head == null) {
            System.out.println("Can't delete: List has no values");
            return;
        }
        if (head.data == value) {
            head = head.next;
            System.out.println("Deleted value " + value);
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
            System.out.println("Deleted value " +value);
        }
        else {
            System.out.println("Can't delete: Value " + value + " not found");
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || head == null) {
            System.out.println("Can't delete: Invalid index");
            return;
        }
        if (index == 0) {
            head = head.next;
            System.out.println("Deleted index " + index);
            return;
        }
        Node temp = head;
        for (int i=0; temp!=null && i<index-1; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            System.out.println("Can't delete: Invalid index");
            return;
        }
        temp.next = temp.next.next;
        System.out.println("Deleted index " + index);

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

    public void display() {
        Node temp = head;
        System.out.print("List: ");
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertAtBeginning(1);
        list.insertAtBeginning(2);
        list.insertAtBeginning(3);

        list.insertAtEnd(4);
        list.insertAtIndex(2,5);

        list.deleteByValue(8);
        list.deleteAtIndex(2);

        System.out.println(list.search(2));

        list.display();
    }
}
