package hw4_20001898_BuiKhanhDuy.bai2;

import java.util.Iterator;

public class StackArray<E> implements StackInterface {

  private E[] array;
  private int defaultSize = 100;
  int lastIndex = -1;

  public StackArray() {
    array = (E[]) new Object[defaultSize];
  }

  public StackArray(int size) {
    array = (E[]) new Object[size];
  }

  @Override
  public void push(Object element) {
    try {
      array[++lastIndex] = (E) element;
    } catch (Exception e) {
      System.out.println("Stack is full");
    }
  }

  @Override
  public E pop() throws Exception {
      if (lastIndex <= -1) throw new Exception("Nothing left to pop");
      return array[lastIndex--];
  }

  @Override
  public boolean isEmpty() {
      return lastIndex == -1;
  }

  @Override
  public Object top() throws Exception {
      if (isEmpty()) throw new Exception("Stack is empty, there is no top!");
      else return array[lastIndex];
  }

  @Override
  public Iterator iterator() {
      Iterator<E> it = new Iterator<E>() {
          int currentIndex = -1;
          @Override
          public boolean hasNext() {
              return currentIndex < lastIndex;
          }

          @Override
          public E next() {
              return array[++currentIndex];
          }
      };
      return it;
  }
}
