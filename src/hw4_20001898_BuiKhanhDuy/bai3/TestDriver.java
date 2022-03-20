package hw4_20001898_BuiKhanhDuy.bai3;

import java.util.Iterator;

public class TestDriver {
  public static void main(String[] args) {
    ArrayQueue<Integer> queue = new ArrayQueue<>(5);
    for (int i = 1; i <= 5; i++) {
      queue.enqueue(i);
    }
    print(queue);
    queue.dequeue();
    queue.dequeue();
    queue.enqueue(7);
    queue.enqueue(8);
    print(queue);
    queue.printArray();
  }

  static void print(ArrayQueue<Integer> queue) {
    Iterator<Integer> it = queue.iterator();
    while (it.hasNext()) System.out.println(it.next());
    System.out.println("-----------------------------");
  }
}
