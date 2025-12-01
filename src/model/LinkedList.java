package model;

public class LinkedList<T extends Comparable> {
    private Node<T> first;
    private Node<T> last;
    private int length;

    public LinkedList() {
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    public void insert(T elem) {
        Node<T> born = new Node<T>(elem);

        if(this.first == null) {
            this.first = born;
            this.last = born;
        }
        else {
            this.last.setNext(born);
            this.last = born;
        }
        this.length++;
    }

    public boolean elemExists(T elem) {
        Node<T> aux = this.first;
        while(aux != null) {
            if(aux.getValue().equals(elem)) {
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }

    public boolean deleteElem(T elem) {
        Node<T> aux = this.first;
        Node<T> prev = null;
        while(aux != null) {
            if(aux.getValue().equals(elem)) {
                if(aux==this.first) {
                    this.first = this.first.getNext();
                    if(aux == this.last) {
                        this.last = null;
                    }
                }
                else {
                    prev.setNext(aux.getNext());
                    if(aux == this.last) {
                        this.last = prev;
                    }
                    this.length--;
                    return true;
                }
            }
            prev = aux;
            aux = aux.getNext();
        }
        return false;
    }

    @Override
    public String toString() {
        Node aux = this.first;
        String s = "[";
        while(aux != null) {
            s+=aux.getValue();
            if(aux != this.last) {
                s += ",";
            }
            aux = aux.getNext();
        }
        return (s+"]");
    }
}
