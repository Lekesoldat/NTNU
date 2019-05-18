import java.util.Iterator;

public class CustomListIterator<T> implements Iterator<T> {
    // Base
    Node<T> current;

    public CustomListIterator(Node base) {
        this.current = base;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        Node<T> tmp = this.current;
        this.current = this.current.getNext();
        return tmp.getData();
    }
}
