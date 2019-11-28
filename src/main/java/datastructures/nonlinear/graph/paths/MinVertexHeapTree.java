package datastructures.nonlinear.graph.paths;

import datastructures.nonlinear.tree.Heap;

public class MinVertexHeapTree extends Heap<Graph.Vertex> {

  public MinVertexHeapTree(int capacity) {
    this.capacity = capacity;
    items = new Graph.Vertex[capacity];
  }

  @Override
  public void heapifyDown() {
    int index = 0;
    while (hasLeftChild(index)) {
      int smallerChildIndex = getLeftChildIndex(index);

      if (hasRightChild(index) && rightChild(index).weight < leftChild(index).weight) {
        smallerChildIndex = getRightChildIndex(index);
      }

      if (items[index].weight < items[smallerChildIndex].weight) {
        break;
      } else {
        swap(index, smallerChildIndex);
      }
      index = smallerChildIndex;
    }
  }

  @Override
  public void heapifyUp() {
    int index = size - 1;
    while (hasParent(index) && parent(index).weight > items[index].weight) {
      swap(getParentIndex(index), index);
      index = getParentIndex(index);
    }
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public static void main(String... args) {
    MinVertexHeapTree minVertexHeapTree = new MinVertexHeapTree(3);
    minVertexHeapTree.add(new Graph.Vertex("a", 10));
    minVertexHeapTree.add(new Graph.Vertex("aa", 1));
    minVertexHeapTree.add(new Graph.Vertex("aaa", 10));

    System.out.println(minVertexHeapTree.poll().name);
  }
}
