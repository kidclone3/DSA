package hw4.Stack;

class Node<T> {
    T data;
    Node next;
    public Node() {
        next = null;
    }
    public Node(T data) {
        this.data =data;
        next = null;
    }
}

public class Stack<T> {
    int t = 0;
    Node<T> head = new Node<T>();
    public void push(T data) {
        Node<T> newHead = new Node<T>(data);
        newHead.next = head;
        head = newHead;
    }
    public int size() {
        return t;
    }
    public T pop() {
        t--;
        T temp = head.data;
        head = head.next;
        return temp;
    }
}
