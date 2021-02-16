package datastructures.nonlinear.tree;

public class MaxIntHeapTree extends Heap<Integer> {

  public MaxIntHeapTree(int capacity) {
    this.capacity = capacity;
    items = new Integer[capacity];
  }

  @Override
  public void heapifyDown() {
    int index = 0;
    while (hasLeftChild(index)) {
      int smallerChildIndex = getLeftChildIndex(index);

      if (hasRightChild(index) && rightChild(index) > leftChild(index)) {
        smallerChildIndex = getRightChildIndex(index);
      }

      if (items[index] > items[smallerChildIndex]) {
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


  }
}
