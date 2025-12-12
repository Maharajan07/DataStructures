public class CircularQueueArr {
    int size = 5;
    int[] arr;
    int front = -1;
    int rear = -1;

    CircularQueueArr() {
        arr = new int[size];
    }

    void enqueue (int data) {
        if ((rear+1)%size == front) {
            throw new IndexOutOfBoundsException("Queue is full");
        }
        if (front == -1) {
            front = 0;
        }
        rear = (rear+1)%size;
        arr[rear] = data;
    }

    int dequeue() {
        if (front == -1) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        int temp = arr[front];

        if (front == rear) {
            front = rear = -1;
        }
        else {
            front = (front+1)%size;
        }
        return temp;
    }

    void display() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Queue elements: ");
        int i = front;
        while (true) { 
            System.out.print(arr[i] + " ");
            if (i == rear) {
                break;
            }
            i = (i+1)%size;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueueArr queue = new CircularQueueArr();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
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
