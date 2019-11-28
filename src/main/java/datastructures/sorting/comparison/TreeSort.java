package datastructures.sorting.comparison;

import datastructures.nonlinear.tree.BinarySearchTree;

public class TreeSort {

  public static void main(String... args) {
    BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>();
    binarySearchTree.add(50, "Boss");
    binarySearchTree.add(25, "Vice President");
    binarySearchTree.add(15, "Office Manager");
    binarySearchTree.add(30, "Secretary");
    binarySearchTree.add(75, "Sales Manager");
    binarySearchTree.add(85, "Sales1");
    binarySearchTree.add(95, "Sales2");

    binarySearchTree.inOrderTraveseTree(binarySearchTree.getRootNode());
    System.out.println("\n");
    binarySearchTree.inOrderTraveseTreeDesc(binarySearchTree.getRootNode());
  }
}
