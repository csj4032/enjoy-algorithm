package structure;

public class StructurePrinter<T> implements Printer<T> {

    @Override
    public void print(Structure<T> structure, PrintOrder order) {
        if (structure.isEmpty()) {
            System.out.println("Structure is empty.");
            return;
        }

        if (order == PrintOrder.FIFO) {
            firstInFirstOut(structure);
        } else if (order == PrintOrder.LIFO) {
            lastInFirstOut(structure);
        } else {
            throw new IllegalArgumentException("Unsupported print order: " + order);
        }
    }

    private void firstInFirstOut(Structure<T> structure) {
        Node<T> current = structure.head();
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    private void lastInFirstOut(Structure<T> structure) {
        lastInFirstOutRecursive(structure.head());
    }

    private void lastInFirstOutRecursive(Node<T> node) {
        if (node == null) return;
        lastInFirstOutRecursive(node.next);
        System.out.println(node.value);
    }
}
