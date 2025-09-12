public class Node {

    private Object value;
    private Node next;

    public Node(Object value) {
        this.value = value;
        this.next = null;
    }

    public Node getNext() {
        return next;
    }
    public void setNext(Node n) {
        this.next = n;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object v) {
        this.value = v;
    }

}
