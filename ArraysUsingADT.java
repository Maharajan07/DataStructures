public class ArraysUsingADT {
    private int[] arr;
    private int capacity;
    private int size;

    //contructor
    public ArraysUsingADT(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        size = 0;
    }

    //create
    public boolean insert(int index, int element) {
        if (capacity <= size || index < 0 || index > size) {
            System.out.println("Insert Faild: Invalid index or Array is full!");
            return false;
        }
        for (int i=size; i>index; i--) {
            arr[i] = arr[i-1];
        }
        arr[index] = element;
        size++;
        return true;
    }

    //delete
    public boolean delete(int index) {
        if (index < 0 || index > size) {
            System.out.println("Delete failed: Invalid index");
            return false;
        }
        for (int i=index; i < size; i++) {
            arr[i] = arr [i+1];
        }
        size--;
        return true;
    }

    //get
    public int get(int index) {
        if ( index < 0 || index > size) {
            System.out.println("Get failed: Invalid index or Array is full!");
            return -1;
        }
        return arr[index];
    }
    
    //getSize
    public int getSize() {
        System.out.println("Size of the array is: " + size);
        return size;
    }

    //getCapacity
    public int getCapacity() {
        System.out.println("Capacity of the array is: " + capacity);
        return capacity;
    }

    //set
    public boolean set(int index, int value) {
        if ( index < 0 || index > size) {
            System.out.println("Set failed: Invalid index or Array is full!");
            return false;
        }
        arr[index] = value;
        return true;
    }

    //search
    public int search(int target) {
        for (int i=0; i < size; i++) {
            if (arr[i] == target)
            return i;
        }
        return -1;
    }

    //display
    public void display() {
        System.out.print("Array: ");
        for (int i=0; i<size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    //main
    public static void main (String[] args) {
    ArraysUsingADT array = new ArraysUsingADT(10);

    array.getCapacity();

    array.insert(0, 10);
    array.insert(1, 20);
    array.insert(2, 30);
    array.insert(1, 15);  // Insert in between

    array.display();  // Expected: 10 15 20 30

    array.set(2, 25);
    System.out.println("Element at index 2: " + array.get(2));  // Expected: 25

    array.delete(1);
    array.display();  // Expected: 10 25 30

    System.out.println("Index of 30: " + array.search(30)); // Expected: 2
    array.getSize();

}
}

