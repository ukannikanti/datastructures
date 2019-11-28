package datastructures.linear.stack;

public class LinkedListStack<E> {

  private Node<E> head;

  public void push(E value) {
    Node<E> newNode = new Node<>(value, null);
    if (head == null) {
      head = newNode;
    } else {
      Node<E> old = head;
      head = newNode;
      head.next = old;
    }
  }

  public E pop() {
    if (head == null) {
      return null;
    }

    E data = head.data;
    head = head.next;
    return data;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public void print() {
    while (head != null) {
      System.out.println(pop());
    }
  }

  public static void main(String... args) {
    LinkedListStack linkedListStack = new LinkedListStack();
    linkedListStack.push(1);
    linkedListStack.push(2);
    linkedListStack.push(3);
    linkedListStack.push(4);
    linkedListStack.push(5);

    linkedListStack.print();
  }

  class Node<E> {
    E data;
    Node<E> next;

    Node(E data, Node<E> next) {
      this.data = data;
      this.next = next;
    }
  }
}
