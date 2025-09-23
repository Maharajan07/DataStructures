public class Array {
    private int[] arr;      // underlying array
    private int capacity;   // Total capacity of the array
    private int size;       // Number of elements currently in array

    //constructor
    public Array(int capacity) {
        arr = new int[capacity];
        this.capacity = capacity;
        size = 0;
    }

    //insert at index
    public boolean insert(int index, int element) {
        if (index < 0 || index > size || size >= capacity) {
            System.out.println("Can't Insert: Invalid index");
            return false;
        }
        for (int i=size; i>index; i--) {
            arr[i] = arr[i-1];
        }
        arr[index] = element;
        size++;
        return true;
    }

    //delete at index
    public boolean delete(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Can't delete: Invalid index");
            return false;
        }
        for (int i=0; i<size-1; i++) {
            arr[i] = arr[i+1];
        }
        size--;
        return true;
    }

    //get element at index
    public int get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Get failed: Invalid index");
            return -1;
        }
        return arr[index];
    }

    //set element at index
    public boolean set(int index, int element){
        if (index < 0 || index >= size) {
            System.out.println("Set failed: Invalid index");
            return false;
        }
        arr[index] = element;
        return true;
    }

    //search for elements
    public int search(int target) {
        for (int i=0; i<size; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    //get current size
    public int getSize() {
        return size;
    }

    //get capacity
    public int getCapacity() {
        return capacity;
    }

    //display
    public void display() {
        System.out.print("Array: ");
        for (int i=0; i<size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array arr = new Array(5);

        arr.insert(0,1);
        arr.insert(1,2);
        arr.insert(2,3);
        arr.insert(1,7);
        arr.insert(6,9);

        arr.delete(1);
        arr.delete(-4);

        arr.display();
        System.out.println("Capacity of the array: " + arr.getCapacity());
        System.out.println("Current size: " + arr.getSize());

        arr.delete(1);
        arr.display();
        System.out.println("Current size: " + arr.getSize());

        System.out.println("Element at index 2: " + arr.get(2));

        arr.set(1,8);
        arr.display();

        System.out.println("Index of 3: " + arr.search(3));
    }
}
