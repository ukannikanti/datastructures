package datastructures.linear.list;

import java.util.Arrays;
import java.util.HashSet;

public class ArrayList<E> {
  private int size = 0;
  private static final int DEFAULT_CAPACITY = 10;
  private Object elements[];

  public ArrayList() {
    // Initialize with default capacity
    elements = new Object[DEFAULT_CAPACITY];
  }

  public void add(E e) {
    if (size == elements.length) {
      ensureCapa();
    }
    elements[size++] = e;
  }

  public E get(int index) {
    if (index < 0 || size < index) {
      throw new IndexOutOfBoundsException();
    } else {
      return (E) elements[index];
    }
  }

  public E remove(int index) {
    E oldValue = null;

    if (size > index && index >= 0) {
      oldValue = (E) elements[index];
      int numMoved = size - index - 1;
      if (numMoved > 0)
        System.arraycopy(elements, index + 1, elements, index, numMoved);
      elements[--size] = null; // clear to let GC do its work
    }

    return oldValue;
  }

  public int search(Object o) {
    if (o == null) {
      for (int i = 0; i < size; i++)
        if (elements[i] == null)
          return i;

    } else {
      for (int i = 0; i < size; i++)
        if (o.equals(elements[i]))
          return i;
    }
    return -1;
  }

  private void ensureCapa() {
    int newSize = elements.length * 2;
    elements = Arrays.copyOf(elements, newSize);
  }
}
