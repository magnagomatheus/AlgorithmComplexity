public class LinkedList<T> {

    private Node first;
    private Node last;
    private int length;
    //private boolean ordered;

    public LinkedList() {
        this.first = null;
        this.last = null;
        this.length = 0;
        //this.ordered = ordered;
    }

    public void insert(Object elem) {
        Node born = new Node(elem);

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

    public boolean elemExists(Object elem) {
        Node aux = this.first;
        while(aux != null) {
            if(aux.getValue().equals(elem)) {
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }

    public boolean deleteElem(Object elem) {
        Node aux = this.first;
        Node prev = null;
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
