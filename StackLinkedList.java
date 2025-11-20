class Node {
    int data;
    Node next;

    Node (int data) {
        this.data = data;
    }
}

public class StackLinkedList {
    
    Node top = null;
    int size = 0;

    void push(int data) {
        Node newNode = new Node(data);

        newNode.next = top;
        top = newNode;
        size++;
    }

    int pop() {
        if (top == null) {
            throw new IllegalStateException("Stack UnderFlow");
        }
        int temp = top.data;
        top = top.next;
        size--;

        return temp;
    }

    int peek() {
        if (top == null) {
            throw new IllegalStateException("Stack is Empty");
        }
        return top.data;
    }

    boolean isEmpty() {
        return top == null;
    }

    int getSize() {
        return size;
    }

    public static void main(String[] args) {
        
        StackLinkedList stack = new StackLinkedList();

        stack.push(5);
        stack.push(6);
        stack.push(2);
        stack.push(7);

        System.out.println("Poped: " + stack.pop());
        
        System.out.println("peek: " + stack.peek());

        System.out.println("Empty: " + stack.isEmpty());

        System.err.println("Size: " + stack.getSize());
    }
}
