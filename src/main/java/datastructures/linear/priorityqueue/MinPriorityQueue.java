package datastructures.linear.priorityqueue;

import datastructures.nonlinear.tree.MinIntHeapTree;

public class MinPriorityQueue {
  MinIntHeapTree minIntHeapTree;

  public MinPriorityQueue(int capacity) {
    minIntHeapTree = new MinIntHeapTree(capacity);
  }

  public void push(int element) {
    minIntHeapTree.add(element);
  }

  public int poll() {
    return minIntHeapTree.poll();
  }

  public boolean isEmpty() {
    return minIntHeapTree.isEmpty();
  }

  public static void main(String... args) {
    MinPriorityQueue minPriorityQueue = new MinPriorityQueue(6);
    minPriorityQueue.push(10);
    minPriorityQueue.push(20);
    minPriorityQueue.push(12);
    minPriorityQueue.push(8);
    minPriorityQueue.push(25);
    minPriorityQueue.push(9);

    System.out.println(minPriorityQueue.poll());
  }
}
