public class QueueLinkedList {
    class Node {
        int data;
        Node next;

        Node (int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node front, rear;

    QueueLinkedList() {
        this.front = this.rear = null;
    }

    void enqueue (int data) {
        Node newNode = new Node(data);
        
        if (front == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = rear.next;
    }
    // Time Complexity: O(1)

    int dequeue() {
        if (front == null) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        int temp = front.data;
        front = front.next;
        return temp;
    }
    // Time Complexity: O(1)

    void display() {
        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue elements: ");
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    // Time Complexity: O(n)

    public static void main(String[] args) {
        QueueLinkedList queue = new QueueLinkedList();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.display();

        System.out.println("Dequeued : " + queue.dequeue());
        System.out.println("Dequeued : " + queue.dequeue());
        System.out.println("Dequeued : " + queue.dequeue());
        System.out.println("Dequeued : " + queue.dequeue());
        queue.display();

        queue.enqueue(60);
        queue.enqueue(70);
        queue.display();
    }
}
