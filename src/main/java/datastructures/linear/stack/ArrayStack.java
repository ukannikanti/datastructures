package datastructures.linear.stack;

public class ArrayStack<E> {

  private Object[] elements;
  private int stackSize;
  private int topOfStack;

  public ArrayStack(int size) {
    elements = new Object[size];
    this.stackSize = size;
    this.topOfStack = -1;
  }

  public void push(E element) {
    if (topOfStack + 1 < stackSize) {
      elements[topOfStack] = element;
      topOfStack++;
    } else {
      System.out.println("ArrayStack is full");
    }
  }

  public E pop() {
    if (topOfStack >= 0) {
      return (E) elements[topOfStack--];
    } else {
      return null;
    }
  }

  public E peek() {
    if (topOfStack >= 0) {
      return (E) elements[topOfStack];
    } else {
      return null;
    }
  }
}
