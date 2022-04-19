package hw4_20001898_BuiKhanhDuy.bai3;

import java.util.Iterator;

public class LinkedListQueue<E> implements QueueInterface<E> {

  class Node<E> {
    E data;
    Node next;

    Node(E e) {
      data = e;
      next = null;
    }
  }

  Node head, tail;
  int size = 0;

  public LinkedListQueue() {
    head = tail = null;
  }
  public boolean isEmpty() {
    return size == 0;
  }
  public E dequeue() {
    E result = null;
    if (size != 0) {
      result = (E) head.data;
      if (head.next != null) head = head.next;
      size--;
    }
    return result;
  }

  public void enqueue(E e) {
    if (head == null) {
      head = tail = new Node<E>(e);
    } else {
      tail = tail.next = new Node<E>(e);
    }
    size++;
  }

  @Override
  public Iterator<E> iterator() {
    return new LinkedListQueueIterator ();
  }
  class LinkedListQueueIterator implements Iterator<E> {
    private Node current = head;
    public boolean hasNext() {
      return current != null;
    }
    public E next() {
      E result = (E) current.data;
      current = current.next;
      return result;
    }
  }
}
