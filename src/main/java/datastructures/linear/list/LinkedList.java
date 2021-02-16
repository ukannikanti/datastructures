package datastructures.linear.list;

public class LinkedList<E> {
    Node<E> head;
    Node<E> tail;

    public void add(E data) {
        Node<E> newNode = new Node<>(data, null);

        if (head == null) {
            this.head = newNode;
            this.tail = head;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
    }

    public void add(E data, int position) {
        Node<E> newNode = new Node(data, null);

        if (head == null && position > 0) {
            System.out.println("Invalid position specified!!");
        }

        if (head == null || position == 0) {
            head = newNode;
        } else {
            int i = 0;
            Node current = head;
            Node previous = null;
            while (i < position) {
                previous = current;
                current = current.next;

                if (current == null) {
                    break;
                }
                i++;
            }
            newNode.next = current;
            previous.next = newNode;
        }
    }

    public E get(int position) {
        if (head == null) {
            System.out.println("Invalid position specified!!");
            return null;
        }

        int i = 0;
        Node<E> current = head;
        while (i < position) {
            current = current.next;
            if (current == null) {
                break;
            }
            i++;
        }
        return current.data;
    }

    public void remove(String value) {
        Node<E> current = head;
        Node<E> previous = current;

        while (current != null && !current.data.equals(value)) {
            previous = current;
            current = current.next;
        }

        if (current != null) {
            previous.next = current.next;
        }
    }

    public void print() {
        Node<E> currentNode = this.head;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public void printHead() {
        System.out.println("Head Value: " + head.data);
    }

    public void printTail() {
        System.out.println("Tail Value: " + tail.data);
    }


    class Node<E> {
        Node next;
        E data;

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String... args) {
        LinkedList linkedList = new LinkedList();
        System.out.println("====== INSERT ==========");
        // Insert data to linked list
        linkedList.add("apple");
        linkedList.add("banana");
        linkedList.add("orange");
        linkedList.add("grapes");

        // insert data at position 3.
        linkedList.add("strawberries", 3);
        linkedList.print();

        System.out.println("\n====== GET ==========");
        String element = (String) linkedList.get(2);
        System.out.println(element);

        System.out.println("\n====== DELETE ==========");
        linkedList.remove("banana");
        linkedList.print();


        System.out.println("\n====== Head & Tail Values ==========");

        linkedList.printHead();
        linkedList.printTail();
    }
}
