package datastructures.linear.priorityqueue;

import datastructures.nonlinear.tree.MaxIntHeapTree;

public class MaxPriorityQueue {
  MaxIntHeapTree maxIntHeapTree;

  public MaxPriorityQueue(int capacity) {
    maxIntHeapTree = new MaxIntHeapTree(capacity);
  }

  public void push(int element) {
    maxIntHeapTree.add(element);
  }

  public int poll() {
    return maxIntHeapTree.poll();
  }

  public static void main(String... args) {
    MaxPriorityQueue maxPriorityQueue = new MaxPriorityQueue(6);
    maxPriorityQueue.push(10);
    maxPriorityQueue.push(20);
    maxPriorityQueue.push(12);
    maxPriorityQueue.push(8);
    maxPriorityQueue.push(25);
    maxPriorityQueue.push(9);
  }
}
