package model;

import java.util.Comparator;

public class LinkedListWithComparator<T> {
    private Node<T> first;
    private Node<T> last;
    private int length;
    private final boolean ordered;
    private Comparator<T> comparator;

    public LinkedListWithComparator(boolean isOrdered, Comparator<T> comparator) {
        this.first = null;
        this.last = null;
        this.length = 0;
        this.ordered = isOrdered;
        this.comparator = comparator;
    }

    public void insert(T elem) {
        if(!this.ordered) {
            insertNotOrderedElem(elem);
        } else {
            insertOrderedElem(elem);
        }
    }

    private void insertNotOrderedElem(T elem) {
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

    private void insertOrderedElem(T elem) {
        Node<T> born = new Node<T>(elem);
        Node<T> current, prev;
        current = this.first;
        prev = null;

        if(this.first == null) {
            this.first = born;
            this.last = born;
        }
        else {
            while(current != null && this.comparator.compare(current.getValue(), elem) < 0) {
                prev = current;
                current = current.getNext();
            }

            if(prev == null) {
                born.setNext(this.first);
                this.first = born;
            }
            else if( current == null) {
                this.last.setNext(born);
                this.last = born;
            }
            else {
                prev.setNext(born);
                born.setNext(current);
            }
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

    public T search(T value) {
        if(this.first == null) {
            return null;
        }
        if(this.last.getValue() == value) {
            return this.last.getValue();
        }
        Node<T> aux = this.first;

        if(this.ordered) {
            if(comparator.compare(value, this.last.getValue()) > 0 || comparator.compare(value, this.first.getValue()) < 0) {
                return null;
            }
            while(aux != null) {
                int cmp = comparator.compare(aux.getValue(), value);
                if(cmp == 0) {
                    return aux.getValue();
                } else if(cmp > 0) {
                    return null;
                }
                aux = aux.getNext();
            }
        }
        else {
            while(aux != null) {
                if(aux.getValue().equals(value)) {
                    return aux.getValue();
                }
                aux = aux.getNext();
            }
        }
        return null;
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
