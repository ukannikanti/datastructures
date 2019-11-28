package datastructures.linear.list;

public class CircularLinkedList<E> {
  private Node<E> head;
  private Node<E> tail;
  private int size;

  public void add(E element) {
    Node<E> newNode = new Node<>(element, head);
    if (head == null) {
      head = newNode;
      tail = newNode;
      tail.next = head;
    } else {
      tail.next = newNode;
      tail = newNode;
      tail.next = head;
    }

    size++;
  }

  public void add(E element, int pos) {
    if (head == null && pos > 0) {
      System.out.println("Invalid position specified!!");
    }

    if (head == null) {
      Node<E> newNode = new Node<>(element, head);
      head = newNode;
      tail = newNode;
      tail.next = head;
    } else {
      Node current = head;
      Node previous = null;
      for (int i = 0; i < pos; i++) {
        previous = current;
        current = current.next;
        if (current == null) {
          break;
        }
      }

      Node<E> newNode = new Node<>(element, current);
      previous.next = newNode;

      if (pos == size) {
        tail.next = newNode;
        tail = newNode;
        tail.next = head;
      }
    }

    size++;
  }

  public E get(int pos) {
    if (head == null && pos > size) {
      System.out.println("Invalid operation...");
      return null;
    }

    Node<E> current = head;
    for (int i = 0; i < pos; i++) {
      current = current.next;
      if (current == null) {
        break;
      }
    }
    return current.data;
  }

  public void remove(int pos) {
    if (pos > size) {
      System.out.println("Invalid position specified!!");
    }

    Node<E> current = head;
    Node<E> previous = null;
    for (int i = 0; i < pos; i++) {
      previous = current;
      current = current.next;
      if (current == null) {
        break;
      }
    }

    if (pos == size - 1) {
      tail = previous;
      tail.next = head;
    } else {
      previous.next = current.next;
    }

    size--;
  }

  public void print() {
    Node<E> currentNode = this.head;
    for (int i = 0; i < size; i++) {
      System.out.println(currentNode.data);
      currentNode = currentNode.next;
    }

    System.out.println(head.data + "  =>  " + tail.data);
  }

  class Node<E> {
    Node<E> next;
    E data;

    public Node(E data, Node next) {
      this.data = data;
      this.next = next;
    }
  }

  public static void main(String... args) {
    CircularLinkedList<String> list = new CircularLinkedList<>();
    System.out.println("====== INSERT ==========");
    list.add("apple");
    list.add("banana");
    list.add("orange");
    list.add("grapes");

    //insert data at position 3.
    list.add("strawberries", 4);
    list.print();

    // remove
    System.out.println("====== REMOVE ==========");
    list.remove(2);
    list.print();
  }

}
