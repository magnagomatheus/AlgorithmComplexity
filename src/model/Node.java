package model;

public class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public Node<T> getNext() {
        return next;
    }
    
    public void setNext(Node<T> n) {
        this.next = n;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T v) {
        this.value = v;
    }
}
