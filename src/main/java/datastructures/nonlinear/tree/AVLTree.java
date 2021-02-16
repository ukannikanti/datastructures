package datastructures.nonlinear.tree;

public class AVLTree {

    class Node {
        int key;
        int height;
        int bf;
        Node left, right;

        public Node(int key) {
            this.key = key;
        }
    }

    private Node root;
    private int size;

    // Insert the new node to tree.
    public void insert(int key) {
        root = insert(root, key);
        size++;
    }

    private Node insert(Node node, int key) {
        if (node == null)
            return new Node(key);

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        }

        // Update height and balance factor
        update(node);

        // Check AVL tree conditions.
        return node;
    }

    // Update both height and balance factor of a node.
    private void update(Node node) {
        int leftNodeHeight = node.left == null ? -1 : node.left.height;
        int rightNodeHeight = node.right == null ? -1 : node.right.height;
        node.height = 1 + Math.max(leftNodeHeight, rightNodeHeight);
        node.bf = leftNodeHeight - rightNodeHeight;
    }

    private Node balance(Node node) {
        // Left heavy tree
        if (node.bf == 2) {

        }

        return node;
    }

    private int height(Node node) {
        if (node == null)
            return -1;

        return node.height;
    }

}
