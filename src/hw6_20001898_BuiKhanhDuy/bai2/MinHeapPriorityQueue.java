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
  protected int n = 1; // Mặc định
  protected int capability = 1000; // Kích cỡ tối đa
  // Vì ta bắt đầu từ 1 nên thực tế sẽ có 101 phần tử trong mảng.

  MinHeapPriorityQueue() { // Nếu không truyền gì vào thì kích cỡ sẽ mặc định là 100.
    heapPQ = new ArrEntry[capability];
  }

  MinHeapPriorityQueue(int capability) {
    this.capability = capability;
    heapPQ = new ArrEntry[capability];
  }

  boolean isEmpty() {
    return n == 1;
  }

  ArrEntry getMin() {
    return heapPQ[1];
  }

  void insert(K key, E element) {
    // Thêm vào vị trí cuối cùng, sau đó gọi hàm upHeap.
    heapPQ[n] = new ArrEntry<K, E>(key, element);
    upHeap(n);
    n++;
  }

  void removeMin() { // Xóa min đi.
    //    Ý tưởng: biến node gốc thành null => downHeap
    if (isEmpty()) {
      return;
    }
    heapPQ[1] = heapPQ[n - 1];
    if (n >= 2) {
      upHeap(2);
    }
    if (n >= 3) {
      upHeap(3);
    }
    n--;
  }
  // Các phương thức bổ sung
  protected ArrEntry getParent(int i) {
    return heapPQ[i >> 1]; // >>1 ~ /2, nhưng máy chạy nhanh hơn
  }

  protected void swap(int i, int j) {
    ArrEntry temp = heapPQ[i];
    heapPQ[i] = heapPQ[j];
    heapPQ[j] = temp;
  }

  protected void upHeap(int i) { // vun lên
    while (i > 1 && getParent(i).key.compareTo(heapPQ[i].key) > 0) { // Nếu chưa thỏa mãn
      swap(i, i >> 1);
      i >>= 1;
    }
  }

  protected void downHeap(int i) { // vun xuống
    int left = i << 1; // ~ 2*i
    int right = i << 1 | 1; // ~ 2*i+1
    while (i < n) {
      if (right < n) { // This node has 2 children.
        if (heapPQ[i].key.compareTo(heapPQ[left].key) < 0
            && heapPQ[i].key.compareTo(heapPQ[right].key)
                < 0) { // Node hiện tại đã bé hơn 2 node con
          return; // Thoát
        } else {
          // Ưu tiên swap sang bên nào lớn hơn
          if (heapPQ[left].key.compareTo(heapPQ[right].key) >= 0) {
            swap(left, i);
            i = left;
          } else {
            swap(right, i);
            i = right;
          }
          left = i << 1;
          right = i << 1 | 1;
        }
      } else {
        if (left < n) {
          if (heapPQ[i].key.compareTo(heapPQ[left].key) >= 0) {
            swap(i, left);
          }
          return; // kết thúc luôn
        } else {
          return; // hết node con
        }
      }
    }
  }
}
