public class DynamicArray {
    private int[] arr;      // Underlying array
    private int capacity;   // Total capacity of the array
    private int size;       // Number of elements currently in array

    // constructor
    public DynamicArray(int capacity) {
        arr = new int[capacity];
        this.capacity = capacity;
        size = 0;
    }
    
    // insert at index
    public boolean insert(int index, int value) {
        if (index < 0 || index > size) {
            System.out.println("Can't insert: Invalid index");
            return false;
        }
        else if (size >= capacity) {
            resize();
        }
        for (int i=size; i>index; i--) {
            arr[i] = arr[i-1];
        }
        arr[index] = value;
        size++;
        return true;
    }

    // delete at index
    public boolean delete(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Can't delete: Invalid index");
            return false;
        }
        for (int i=index; i<size-1; i++) {
            arr[i] = arr[i+1];
        }
        size--;
        return true;
    }

    // set at index
    public boolean set(int index, int value) {
        if (index < 0 || index >= size) {
            System.out.println("Can't set: Invalid index");
            return false;
        }
        arr[index] = value;
        return true;
    }

    // get at index
    public int get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Can't get: Invalid index");
            return -1;
        }
        return arr[index];
    }

    // search for elements
    public int search(int target) {
        for (int i=0; i<size; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // get current capacity
    public int getCapacity() {
        return capacity;
    }

    // get current size
    public int getSize() {
        return size;
    }
    
    // resize the array
    public void resize() {
        capacity *= 2;
        int[] newArr = new int[capacity];
        for (int i=0; i<size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    // display
    public void display() {
        System.out.print("Array: ");
        for (int i=0; i<size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        DynamicArray arr = new DynamicArray(3);

        arr.insert(0,1);
        arr.insert(1,2);
        arr.insert(2,3);
        arr.insert(3,4);
        arr.insert(4,5);
        arr.insert(0,2);
        arr.display();

        arr.delete(0);
        arr.display();

        System.out.println("Element at 3 index: " + arr.get(3));
        arr.set(4,6);
        arr.display();

        System.out.println("Index of 3: " + arr.search(3));
        System.out.println("Current Capacity: " + arr.getCapacity());
        System.out.println("Current Size: " + arr.getSize());
    }
}
