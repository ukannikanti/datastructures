package datastructures.linear.queue;

import datastructures.linear.stack.LinkedListStack;

public class QueueLinkedList<E> {

  private Node<E> head;

  public void enqueue(E data) {
    Node<E> newNode = new Node<>(data, null);
    if (head == null) {
      head = newNode;
    } else {
      Node<E> current = head;
      Node<E> previous = null;
      while (current != null) {
        previous = current;
        current = current.next;
      }
      previous.next = newNode;
    }
  }

  public E dequeue() {
    if (head == null) {
      return null;
    }

    E data = head.data;
    head = head.next;
    return data;
  }

  public void print() {
    while (head != null) {
      System.out.println(dequeue());
    }
  }

  public static void main(String... args) {
    QueueLinkedList queue = new QueueLinkedList<>();
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(5);
    queue.print();
  }

  class Node<E> {
    E data;
    Node<E> next;

    Node(E e, Node<E> next) {
      this.data = e;
      this.next = next;
    }
  }
}
