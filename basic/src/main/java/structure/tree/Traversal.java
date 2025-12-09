package structure.tree;

import structure.Node;

public class Traversal {

    // 전위 순회
    public void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        preorder(node.prev);
        preorder(node.next);
    }

    // 중위 순회
    public void inorder(Node node) {
        if (node == null) return;
        inorder(node.prev);
        System.out.print(node.value + " ");
        inorder(node.next);
    }

    // 후위 순회
    public void postorder(Node node) {
        if (node == null) return;
        postorder(node.prev);
        postorder(node.next);
        System.out.print(node.value + " ");
    }
}
