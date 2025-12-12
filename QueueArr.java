public class QueueArr {
    static int size = 5;
    int[] arr;
    int front = -1;
    int rear = -1;

    QueueArr() {
        arr = new int[size];
    }

    void enqueue (int data) {
        if (rear == size-1) {
            throw new IndexOutOfBoundsException("Queue is full");
        }
        if (front == -1 && rear == -1) {
            front++;
            arr[++rear] = data;
            return;
        }
        arr[++rear] = data;
    }

    int dequeue() {
        if (front == -1 ||rear == -1 || front > rear) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        return arr[front++];
    }

    void display() {
        if (front == -1 || rear == -1 || front > rear) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i=front; i<=rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueArr queue = new QueueArr();

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
