package aizu;

public class BinarySearchTree {

	private Node root;

	private void insert(int k) {
		Node y = null;
		Node x = root;
		Node z = new Node();
		z.key = k;
		z.left = null;
		z.right = null;

		while (x != null) {
			y = x;
			if (z.key < x.key) {
				x = x.left;
			} else {
				x = x.right;
			}
		}

		z.parent = y;
		if (y == null) {
			root = z;
		} else {
			if (z.key < y.key) {
				y.left = z;
			} else {
				y.right = z;
			}
		}
	}

	private void preorder(Node u) {
		if (u == null) return;
		System.out.print(" " + u.key);
		preorder(u.left);
		preorder(u.right);
	}

	private void inorder(Node u) {
		if (u == null) return;
		inorder(u.left);
		System.out.print(" " + u.key);
		inorder(u.right);
	}

	public static void main(String[] args) {
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.insert(30);
		binarySearchTree.insert(88);
		binarySearchTree.insert(12);
		binarySearchTree.insert(1);
		binarySearchTree.insert(20);
		binarySearchTree.insert(17);
		binarySearchTree.insert(25);
		binarySearchTree.preorder(binarySearchTree.root);
		System.out.println();
		binarySearchTree.inorder(binarySearchTree.root);
	}
}

class Node {
	int key;
	Node parent;
	Node left;
	Node right;
}