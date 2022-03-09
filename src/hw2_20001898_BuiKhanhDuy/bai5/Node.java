package hw2_20001898_BuiKhanhDuy.bai5;

public class Node<T> implements Comparable<Node>{
    private T value;
    public Node() {
    }
    public Node(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }

    @Override
    public int compareTo(Node node) {
        if (node.value instanceof Integer) return ((Integer)this.value).compareTo((Integer) node.value);
        if (node.value instanceof Double) return ((Double)this.value).compareTo((Double) node.value);
        if (node.value instanceof String) return ((String)this.value).compareTo((String) node.value);
        return 0;
    }
}
