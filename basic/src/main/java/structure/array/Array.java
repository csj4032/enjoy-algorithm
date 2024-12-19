package structure.array;

public class Array {

    private int[] array;
    private int size;
    private int capacity;

    public Array(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.size = 0;
    }

    public void insert(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == capacity) {
            throw new IllegalStateException();
        }
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = value;
        size++;
    }

    public void append(int value) {
        if (size == capacity) throw new IllegalStateException();
        array[size] = value;
        size++;
    }

    public void prepend(int value) {
        insert(0, value);
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public void remove(int value) {
        int index = indexOf(value);
        if (index != -1) {
            delete(index);
        }
    }

    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public void print() {
        for (int i = 0; i < size; i++) System.out.print(array[i] + " ");
    }
}
