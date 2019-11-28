package datastructures.linear.queue;

public class QueueArray<E> {
  private Object[] queue;
  private int queueSize;
  private int front;
  private int rear;
  private int numberOfItems;

  public QueueArray(int size) {
    this.queue = new Object[size];
    this.queueSize = size;
    this.front = 0;
    this.rear = 0;
    this.numberOfItems = 0;
  }

  public void enqueue(E element) {
    if (numberOfItems >= queueSize) {
      System.out.println("QueueArray is full.. ");
    } else {
      queue[rear] = element;
      rear++;
      numberOfItems++;
    }
  }

  public E dequeue() {
    E e = (E) queue[front];
    front++;
    return e;
  }

  public boolean isEmpty() {
    return front == numberOfItems;
  }

  public void remove() {
    if (numberOfItems >= 0) {
      front++;
    }
  }

  public E peek() {
    return (E) queue[front];
  }
}
