public class StackArray {
    int size;
    int[] stack;
    int top = -1;

    StackArray() {
        size = 100;
        stack = new int[size];
    }

    void push(int data) {
        if (top == size-1) {
            throw new ArrayIndexOutOfBoundsException("Stack Overflow");
        }
        stack[++top] = data;
    }

    int pop() {
        if (top == -1) {
            throw new IllegalStateException("Stack Underflow");
        }
        return stack[top--];
    }

    int peek() {
        if (top == -1) {
            throw new IllegalStateException("Stack Underflow");
        }
        return stack[top];
    }

    boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {

        StackArray stack = new StackArray();

        stack.push(5);
        stack.push(6);
        stack.push(2);
        stack.push(7);

        System.out.println("Poped: " + stack.pop());
        
        System.out.println("peek: " + stack.peek());

        System.out.println("Empty: " + stack.isEmpty());
    }
}
