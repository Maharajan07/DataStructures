public class QueueArr1 {
    static int size = 5;
    int[] arr;
    int rear = -1;

    QueueArr1() {
        arr = new int[size];
    }

    void enqueue (int data) {
        if (rear == size-1) {
            throw new IndexOutOfBoundsException("Queue is full");
        }
        arr[++rear] = data;
    }
    // Time Complexity: O(1)

    int dequeue() {
        if (rear == -1) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        int temp = arr[0];

        for (int i=0; i<rear; i++) {
            arr[i] = arr[i+1];
        }
        rear--;
        return temp;
    }
    // Time Complexity: O(n)

    void display() {
        if (rear == -1) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i=0; i<= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    // Time Complexity: O(n)

    public static void main(String[] args) {
        QueueArr1 queue = new QueueArr1();

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
    }
}