import java.util.Iterator;
import java.util.stream.Collectors;

public class LinkedList<T> implements CustomList<T> {
    // Instance variables
    protected Node head, tail;
    protected int size;

    // Methods

    private void validPlace(int pos) {
        if (pos < 0 || pos > this.size) {
            throw new IllegalArgumentException("Cannot place at position " + pos);
        }
    }

    private void validGet(int pos) {
        if (pos < 0 || pos > this.size - 1) {
            throw new IllegalArgumentException("Nothing at position " + pos);
        }
    }

    private Node<T> getNode(int pos) {
        validGet(pos);

        // Head
        if (pos == 0) {
            return this.head;
        }

        // Tail
        else if (pos == this.size - 1) {
            return this.tail;
        }

        if (pos  < this.size * 0.5) {
            Node node = this.head;
            for (int i = 0; i < pos; i++) {
                node = node.getNext();
            }
            return node;
        } else {
            Node node = this.tail;
            for (int i = 0; i < this.size -  pos - 1; i++) {
                node = node.getPrev();
            }
            return node;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    // Add on a position
    public void add(int pos, T data) {
        validPlace(pos);

        // If list is empty
        if (this.head == null) {
            this.head = this.tail = new Node(data, null, null);
        }

        // Place before head
        else if (pos == 0) {
            Node<T> tmpNode = new Node(data, this.head, null);
            this.head.setPrev(tmpNode);
            this.head = tmpNode;
        }

        // Add after tail
        else if (pos == this.size) {
            Node<T> tmpNode = new Node(data, null, this.tail);
            this.tail.setNext(tmpNode);
            this.tail = tmpNode;
        }

        // Any other position
        else {

            Node<T> existingNode = getNode(pos);

            Node<T> newNode = new Node(data, existingNode, existingNode.getPrev());
            existingNode.getPrev().setNext(newNode);
            existingNode.setPrev(newNode);
        }

        // Increment size
        size++;
    }

    @Override
    public void add(T data) {
        add(this.size, data);
    }

    @Override
    public void setData(int pos, T data) {
        getNode(pos).setData(data);
    }

    @Override
    public T get(int pos) {
        return getNode(pos).getData();
    }

    @Override
    public T remove(int pos) {
        validGet(pos);
        Node<T> node;

        // Size == 1
        if (this.size == 1) {
            node = this.head;
            this.head = this.tail = null;
        }

        // Head
        else if (pos == 0) {
            node = this.head;
            this.head.getNext().setPrev(null);
            this.head = this.head.getNext();
        }

        // Tail
        else if (pos == this.size - 1) {
            node = this.tail;
            this.tail.getPrev().setNext(null);
            this.tail = this.tail.getPrev();
        }

        // Remove anything else
        else {
            node = getNode(pos);
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
        }
        size--;
        return node.getData();
    }

    @Override
    public T remove() {
        return remove(0);
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomListIterator<>(this.head);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(String.format("All %d elements: \n", this.size))
                .append(this.stream().map(T::toString).collect(Collectors.joining(", ")))
                .toString();
    }
}