package hw4_20001898_BuiKhanhDuy.bai2;

import java.util.Iterator;

public class TestDriver {
  public static void main(String[] args) {
    //
    StackArray<Integer> st = new StackArray<>(5);
//    LinkedListStack<Integer> st = new LinkedListStack<>();
    st.push(3);
    st.push(10);
    st.push(10);
    st.push(10);
    st.push(10);
    try {
      Integer temp = st.pop();
    } catch (Exception e) {
      System.out.println("Stack is empty!");
    }

    st.push(11);
    //      temp = st.pop();
    Iterator<Integer> it = st.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }
  }
}
