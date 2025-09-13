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

        // If list is empty, the new element (node) will be the first and last
        if(this.first == null) {
            this.first = born;
            this.last = born;
        }
        else {
            // While not the end of the list and the current node it's a element that is lower than the his next, go to the next element (node)

            // Note that, the order of the conditions makes difference
            while(current != null && this.comparator.compare(current.getValue(), elem) < 0) {
                prev = current;
                current = current.getNext();
            }

            // If previous node is null, so do not enter the loop... So the new lower than the first (node) should be insert at the beginning of the list.
            if(prev == null) {
                born.setNext(this.first);
                this.first = born;
            }

            // If current is null, so its pass through the list and the new node should be insert as the last element.
            else if( current == null) {
                this.last.setNext(born);
                this.last = born;
            }
            // if the current element it's not the first nor last element
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
                // If its first and if its first and last
                if(aux==this.first) {
                    this.first = this.first.getNext();
                    if(aux == this.last) {
                        this.last = null;
                    }
                }
                // If not first, the previous node will point to the next of aux node
                else {
                    prev.setNext(aux.getNext());
                    // If It's last, the last will be the previous node
                    if(aux == this.last) {
                        this.last = prev;
                    }
                    // Quantity decramentation
                    this.length--;
                    return true;
                }
            }
            // If not found yet, prev become aux and aux become the next node of the list.
            prev = aux;
            aux = aux.getNext();
        }
        // If not found the element
        return false;
    }

    public T search(T value) {
        // If the list is empty, there is no reason to search
        if(this.first == null) {
            return null;
        }
        // if the last value is equals to value, so return the element.
        if(this.last.getValue() == value) {
            return this.last.getValue();
        }
        // Assistent node
        Node<T> aux = this.first;

        // If the list it's ordered, so compare the elements,
        // if the elements are equals --> return 0
        // if an element is greater than the other --> return 1
        // if an element is lower than the other --> return -1.
        if(this.ordered) {
            // If the element that we are searching for:
                // is lower than the first element --> so he is not in the list (return null)
                // is greater than the last element --> So he also is not in the list (return null)
            if(comparator.compare(value, this.last.getValue()) > 0 || comparator.compare(value, this.first.getValue()) < 0) {
                return null;
            }
            // If the element may be in the list --> search.
            while(aux != null) {
                // Comparator result
                int cmp = comparator.compare(aux.getValue(), value);
                // If equals --> return the element.
                if(cmp == 0) {
                    return aux.getValue();
                    // if aux is greater than the element, so there is no reason to continue, he is not in the list.
                } else if(cmp > 0) {
                    return null;
                }
                // aux go to the next
                aux = aux.getNext();
            }
        }

        // If the list is not ordered --> search one by one.
        else {
            // While is not the end of the list
            while(aux != null) {
                // If elements are equal --> return element
                if(aux.getValue().equals(value)) {
                    return aux.getValue();
                }
                // go to the next node
                aux = aux.getNext();
            }
        }
        // not found.
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
