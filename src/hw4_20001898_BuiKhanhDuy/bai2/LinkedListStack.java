package hw4_20001898_BuiKhanhDuy.bai2;

import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface<E> {

  class Node {
    E element;
    Node next;

    Node(E element) {
      this.element = element;
      next = null;
    }
  }

  private Node stack = null;

  @Override
  public void push(E element) {
    // Thêm một phần tử vào stack
    Node newNode = new Node(element);
    if (stack == null) {
      stack = newNode;
    } else {
      newNode.next = stack;
      stack = newNode;
    }
  }

  @Override
  public E pop() {
    // Lấy một phần tử khỏi stack
    if (isEmpty()) return null;
    E result = stack.element;
    stack = stack.next;
    return result;
  }

  @Override
  public boolean isEmpty() {
    // Kiểm tra stack rỗng
    return stack == null;
  }

  @Override
  public E top() {
    // Lấy giá trị phần tử đầu tiên của stack
    if (isEmpty()) return null;
    return stack.element;
  }

  @Override
  public Iterator<E> iterator() {
    // TODO Auto-generated method stub
    return new StackIterator();
  }

  class StackIterator<E> implements Iterator<E> {
    private Node currentNode = stack;

    @Override
    public boolean hasNext() {
      // TODO Auto-generated method stub
      return currentNode != null;
    }

    @Override
    public E next() {
      // TODO Auto-generated method stub
      E data = (E) currentNode.element;
      currentNode = currentNode.next;
      return data;
    }
  }
}
