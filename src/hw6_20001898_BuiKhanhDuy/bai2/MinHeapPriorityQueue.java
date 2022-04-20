package hw6_20001898_BuiKhanhDuy.bai2;

public class MinHeapPriorityQueue<K extends Comparable, E> {
  class ArrEntry<K extends Comparable, E> {
    K key;
    E element;

    ArrEntry(K key, E element) {
      this.key = key;
      this.element = element;
    }
  }

  ArrEntry<K, E> heapPQ[];
  protected int n = 0; // Mặc định
  protected int capability = 1000; // Kích cỡ tối đa
  // Vì ta bắt đầu từ 1 nên thực tế sẽ có 101 phần tử trong mảng.

  int size() {
    return n;
  }

  MinHeapPriorityQueue() { // Nếu không truyền gì vào thì kích cỡ sẽ mặc định là 100.
    heapPQ = new ArrEntry[capability];
  }

  MinHeapPriorityQueue(int capability) {
    this.capability = capability;
    heapPQ = new ArrEntry[capability];
  }

  boolean isEmpty() {
    return n == 0;
  }

  int left(int i) {
    return i << 1;
  }

  int right(int i) {
    return i << 1 | 1;
  }

  int parent(int i) {
    return i >> 1; // >>1 ~ /2, nhưng máy chạy nhanh hơn
  }

  boolean isLeaf(int i) { // Ktra xem có còn thuộc cây không .
    return (i > (n >> 1) && i < n);
  }

  void insert(K key, E element) {
    // Thêm vào vị trí cuối cùng, sau đó gọi hàm upHeap.
    heapPQ[++n] = new ArrEntry<K, E>(key, element);
    upHeap(n);
  }

  ArrEntry getMin() {
    return heapPQ[1];
  }

  void removeMin() { // Xóa min đi.
    //    Ý tưởng: biến node gốc thành null => downHeap
    if (isEmpty()) {
      return;
    }
    heapPQ[1] = heapPQ[n--];
    heapPQ[n+1] = null;
    downHeap(1);
  }
  // Các phương thức bổ sung

  protected void swap(int i, int j) {
    ArrEntry temp = heapPQ[i];
    heapPQ[i] = heapPQ[j];
    heapPQ[j] = temp;
  }

  protected void upHeap(int i) { // vun lên
    while (i > 1 && heapPQ[parent(i)].key.compareTo(heapPQ[i].key) > 0) { // Nếu chưa thỏa mãn
      swap(i, parent(i));
      i = parent(i);
    }
  }

  protected void downHeap(int i) { // vun xuống
    if (!isLeaf(i)) { // Nếu đây không phải là 1 node lá và có key lớn hơn bất kì
      //      Node con nào => swap.
      if (heapPQ[i].key.compareTo(heapPQ[left(i)].key) >= 0
          || heapPQ[i].key.compareTo(heapPQ[right(i)].key) >= 0) {
        if (heapPQ[left(i)].key.compareTo(heapPQ[right(i)].key) <= 0) {
          swap(i, left(i));
          downHeap(left(i));
        } else {
          swap(i, right(i));
          downHeap(right(i));
        }
      }
    }
  }
}
