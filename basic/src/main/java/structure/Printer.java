package structure;

public interface Printer<T> {

    enum PrintOrder {
        FIFO, // First-In-First-Out
        LIFO  // Last-In-First-Out
    }

    void print(Structure<T> structure, PrintOrder order);
}
