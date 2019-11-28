package datastructures.linear.list;

public class DoublyLinkedList<E> {
  private Node<E> head;
  private Node<E> tail;
  private int size;

  public void addFirst(E element) {
    Node<E> f = head;
    Node<E> newNode = new Node<>(null, element, f);
    head = newNode;
    if (f == null) {
      head = newNode;
      tail = newNode;
    } else {
      f.prev = newNode;
    }
    size++;
  }

  public void addLast(E element) {
    Node<E> l = tail;
    Node<E> newNode = new Node<>(l, element, null);
    tail = newNode;
    if (l == null)
      head = newNode;
    else
      l.next = newNode;

    size++;
  }

  public E get(int index) {
    if (index < (size >> 1)) {
      Node<E> x = head;
      for (int i = 0; i < index; i++)
        x = x.next;
      return x.data;
    } else {
      Node<E> x = tail;
      for (int i = size - 1; i > index; i--)
        x = x.prev;
      return x.data;
    }
  }

  public void removeFirst() {
    Node<E> next = head.next;
    head.data = null;
    head.next = null; // help GC
    head = next;
    if (next == null)
      tail = null;
    else
      next.prev = null;
    size--;
  }

  public void removeLast() {
    Node<E> prev = tail.prev;
    tail.data = null;
    tail.next = null; // help GC
    tail = prev;
    if (prev == null)
      head = null;
    else
      prev.next = null;
    size--;
  }

  public void iterateForward() {
    System.out.println("iterating forward..");
    Node tmp = head;
    while (tmp != null) {
      System.out.println(tmp.data);
      tmp = tmp.next;
    }
  }

  public void iterateBackward() {
    System.out.println("iterating backword..");
    Node tmp = tail;
    while (tmp != null) {
      System.out.println(tmp.data);
      tmp = tmp.prev;
    }
  }

  class Node<E> {
    E data;
    Node<E> prev;
    Node<E> next;

    Node(Node<E> prev, E data, Node<E> next) {
      this.data = data;
      this.prev = prev;
      this.next = next;
    }
  }

  public static void main(String... args) {
    DoublyLinkedList list = new DoublyLinkedList();
    System.out.println("====== INSERT ==========");
    // Insert data to linked list
    list.addFirst("apple");
    list.addFirst("banana");
    list.addFirst("orange");
    list.addFirst("grapes");
    list.iterateForward();
    list.iterateBackward();

    System.out.println("\n====== GET ==========");
    System.out.println(list.get(1));

    System.out.println("\n====== DELETE ==========");
    list.removeFirst();
    list.removeLast();
    list.iterateForward();
  }
}
