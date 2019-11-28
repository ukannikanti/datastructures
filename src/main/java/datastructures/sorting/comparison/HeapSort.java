package datastructures.sorting.comparison;

import datastructures.nonlinear.tree.MaxIntHeapTree;

public class HeapSort {

  public void sort(int[] items) {
    MaxIntHeapTree maxIntHeapTree = new MaxIntHeapTree(100);
    for (int i = 0; i < items.length; i++) {
      maxIntHeapTree.add(items[i]);
    }

    for (int j = items.length - 1; j > 0; j--) {
      int value = maxIntHeapTree.poll();
      items[j] = value;
    }
  }

  private void print(int[] items) {
    for (int i = 0; i < items.length; i++) {
      System.out.print(items[i] + "  ");
    }
    System.out.println();
  }

  public static void main(String... args) {
    int[] items = {2, 7, 4, 5, 8, 2, 0, 23, 45, 90, 21, 12};
    HeapSort sort = new HeapSort();
    System.out.println("Before sorting......");
    sort.print(items);

    sort.sort(items);

    System.out.println("After sorting......");
    sort.print(items);
  }
}
