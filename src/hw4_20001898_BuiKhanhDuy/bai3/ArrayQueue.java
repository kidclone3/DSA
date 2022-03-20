package hw4_20001898_BuiKhanhDuy.bai3;

import java.util.Iterator;

public class ArrayQueue<E> implements QueueInterface<E> {

  private E[] queue;
  private int n = 0;
  private int top = 0;
  private int count = 0; // ~~ size
  private int default_size = 100;

  public ArrayQueue(int capacity) {
    n = capacity;
    queue = (E[]) new Object[capacity];
  }

  public ArrayQueue() {
    n = default_size;
    queue = (E[]) new Object[default_size];
  }

  @Override
  public void enqueue(E element) {
    // TODO Auto-generated method stub
    // Them ptu vao queue
    int addIndex = (top + count) % queue.length;
    queue[addIndex] = element;
    count++;
  }

  @Override
  public E dequeue() {
    // TODO Auto-generated method stub
    E data = queue[top];
    top = (top + 1) % queue.length;
    count--;
    return data;
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return count == 0;
  }

  @Override
  public Iterator<E> iterator() {
    // TODO Auto-generated method stub
    return new ArrayQueueIterator();
  }

  class ArrayQueueIterator implements Iterator<E> {
    private int current = top;
    private int num = 0;

    @Override
    public boolean hasNext() {
      // TODO Auto-generated method stub
      return num < count;
    }

    @Override
    public E next() {
      // TODO Auto-generated method stub
      E data = queue[(current + num) % n];
      num++;
      return data;
    }
  }

  public void printArray() {
    for (int i = 0; i < queue.length; ++i) {
      System.out.print(queue[i] + " ");
    }
    System.out.println();
  }
}
