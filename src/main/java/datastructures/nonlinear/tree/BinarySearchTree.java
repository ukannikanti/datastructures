package datastructures.nonlinear.tree;

public class BinarySearchTree<E> {
  private Node<E> rootNode;

  // This method is used only for TreeSort class.
  public Node<E> getRootNode() {
    return rootNode;
  }

  public void add(int key, E element) {
    Node<E> newNode = new Node<>(key, element);

    if (rootNode == null) {
      rootNode = newNode;
    } else {
      Node<E> focusNode = rootNode;
      Node<E> parent;

      while (true) {
        parent = focusNode;

        if (key < focusNode.key) {
          focusNode = focusNode.leftChild;
          if (focusNode == null) {
            parent.leftChild = newNode;
            return;
          }
        } else {
          focusNode = focusNode.rightChild;
          if (focusNode == null) {
            parent.rightChild = newNode;
            return;
          }
        }
      }
    }
  }

  public void inOrderTraveseTree(Node<E> focusNode) {
    if (focusNode != null) {
      inOrderTraveseTree(focusNode.leftChild);
      System.out.print(focusNode.key + " -> ");
      inOrderTraveseTree(focusNode.rightChild);
    }
  }

  public void inOrderTraveseTreeDesc(Node<E> focusNode) {
    if (focusNode != null) {
      inOrderTraveseTreeDesc(focusNode.rightChild);
      System.out.print(focusNode.key + " -> ");
      inOrderTraveseTreeDesc(focusNode.leftChild);
    }
  }

  public void preOrderTraveseTree(Node<E> focusNode) {
    if (focusNode != null) {
      System.out.print(focusNode.key + " -> ");
      inOrderTraveseTree(focusNode.leftChild);
      inOrderTraveseTree(focusNode.rightChild);
    }
  }

  public void postOrderTraveseTree(Node<E> focusNode) {
    if (focusNode != null) {
      inOrderTraveseTree(focusNode.leftChild);
      inOrderTraveseTree(focusNode.rightChild);
      System.out.print(focusNode.key + " -> ");
    }
  }

  public Node<E> search(int key) {
    Node<E> focusNode = rootNode;

    if (focusNode == null) {
      return null;
    }

    while (focusNode.key != key) {
      if (key < focusNode.key) {
        focusNode = focusNode.leftChild;
      } else {
        focusNode = focusNode.rightChild;
      }
    }

    return focusNode;
  }

  public void remove(Node<E> root, int key) {
    if (root == null) {
      return;
    }

    Node<E> parent = null;
    Node<E> focusNode = root;

    while (focusNode != null && focusNode.key != key) {
      parent = focusNode;

      if (key < focusNode.key) {
        focusNode = focusNode.leftChild;
      } else {
        focusNode = focusNode.rightChild;
      }
    }

    if (focusNode == null) {
      System.out.println("Key not found!!");
      return;
    }

    // Case 1: No Children
    if (focusNode.leftChild == null && focusNode.rightChild == null) {
      if (focusNode != rootNode) {
        if (parent.leftChild == focusNode) {
          parent.leftChild = null;
        } else {
          parent.rightChild = null;
        }
      }
      // if tree has only root node, delete it and set root to null
      else {
        root = null;
      }
    }// Case 2: One Children
    else if ((focusNode.leftChild == null && focusNode.rightChild != null) || (
        focusNode.leftChild != null && focusNode.rightChild == null)) {

      Node child = (focusNode.leftChild != null) ? focusNode.leftChild : focusNode.rightChild;
      // if node to be deleted is not a root node, then set its parent
      // to its child
      if (focusNode != root) {
        if (focusNode == parent.leftChild) {
          parent.leftChild = child;
        } else {
          parent.rightChild = child;
        }
      } else {
        root = child;
      }
    }// Case 3: Two Children
    else {
      // find its in-order successor node
      Node<E> successor = minimumKey(focusNode.rightChild);
      int val = successor.key;

      remove(root, successor.key);

      focusNode.key = val;
    }
  }

  public Node<E> minimumKey(Node focusNode) {
    while (focusNode.leftChild != null) {
      focusNode = focusNode.leftChild;
    }
    return focusNode;
  }

  class Node<E> {
    int key;
    E element;
    Node<E> leftChild;
    Node<E> rightChild;

    public Node(int key, E element) {
      this.key = key;
      this.element = element;
    }
  }

  public static void main(String... args) {
    BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>();
    binarySearchTree.add(50, "Boss");
    binarySearchTree.add(25, "Vice President");
    binarySearchTree.add(15, "Office Manager");
    binarySearchTree.add(30, "Secretary");
    binarySearchTree.add(75, "Sales Manager");
    binarySearchTree.add(85, "Sales1");
    binarySearchTree.add(95, "Sales2");
    System.out.println("\n============= IN-ORDER ================");
    binarySearchTree.inOrderTraveseTree(binarySearchTree.rootNode);
    System.out.println("\n============= PRE-ORDER ================");
    binarySearchTree.preOrderTraveseTree(binarySearchTree.rootNode);
    System.out.println("\n============= POST-ORDER ================");
    binarySearchTree.postOrderTraveseTree(binarySearchTree.rootNode);

    System.out.println("\n============= Search ================");
    System.out.println(binarySearchTree.search(75).element);
  }
}
