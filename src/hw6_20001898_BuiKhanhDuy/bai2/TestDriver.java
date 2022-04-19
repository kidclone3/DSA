package hw6_20001898_BuiKhanhDuy.bai2;

public class TestDriver {
  public static void main(String[] args) {
    MinHeapPriorityQueue<Integer, Integer> pq = new MinHeapPriorityQueue<Integer, Integer>();
    for(int i = 1; i <= 10; ++i) {
      pq.insert(i, i);
    }
    while (!pq.isEmpty()) {
      System.out.println(pq.getMin().key);
      pq.removeMin();
    }
  }
}