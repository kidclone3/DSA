package hw4_20001898_BuiKhanhDuy.bai2;

public interface StackInterface<E> extends Iterable<E> {
    public void push(E element);
    public E pop() throws Exception;
    public boolean isEmpty();
    public E top() throws Exception;
}
