class Node {
    int data;
    Node next;

    Node (int data) {
        this.data = data;
        this.next = next;
    }
}

public class ReverseLinkedList {
    private Node head;

    // inserting node at beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        System.out.println("Inserted " + data + " at begginning!");
    }

    // inserting node at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            System.out.println("Inserted " + data + " at the end!");
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        System.out.println("Inseted "+ data + " at the end!");
    }

    // inserting node at index
    public void insertAtIndex(int index, int value) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
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
            System.out.println("Can't insert: List is NULL");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println("Inserted " + value + " at index " + index);
    }

    // delete node at index
    public void deleteAtIndex(int index) {
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (index == 0) {
            head = head.next;
            return;
        }
        Node temp = head;
        for (int i=0; temp != null && i<index-1; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        temp.next = temp.next.next;
        System.out.println("Deleted index " + index);
    }

    // delete node by value
    public void deleteByValue(int target) {
        if (head == null) {
            System.out.println("Can't Delete: Value not found!");
            return;
        }
        if (head.data == target) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != target) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
            System.out.println("Deleted value " + target);
        }
        else {
            System.out.println("Can't Delete: Value not found!");
        }

    }

    // search by value
    public boolean search(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == value) return true;
            temp = temp.next;
        }
        return false;
    }

    // search by index
    public int searchByIndex(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        Node temp = head;
        for (int i=0; temp != null && i<index; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }

        return temp.data;
    }

    // revercing a LinkedList
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null) {
            next = current.next;    // store next
            current.next = prev;    // reverse pointer
            prev = current;         // move prev forward
            current = next;         // move current forward
        }
        head = prev;    // new head
    }

    // get total size
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
        System.out.print("List: ");
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }


    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();

        list.insertAtBeginning(1);
        list.insertAtBeginning(2);
        list.insertAtBeginning(3);

        list.insertAtEnd(4);

        System.out.println("Total size of the LinkedList: " + list.size());
        System.out.println("Value at index 2: " + list.searchByIndex(2));

        // list.insertAtIndex(3, 0);

        // list.deleteAtIndex(3);
        // list.deleteByValue(8);
        
        // System.out.println("Value 4 found in list: " + list.search(4));

        list.display();
        list.reverse();
        list.display();
        
    }
}
