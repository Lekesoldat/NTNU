/**
    Public double linked list. 
 */
public class LinkedList extends IList<T> {
    // Nested class
    public class Node{
        protected T value;
        protected Node next;
        protected Node previous;

        public Node(T value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }

    // Instance variables for 
    protected Node start;
    protected Node end;
    private int size;

    // Methods
    @Override
    public int size(){
        return this.size;
    }

    @Override
    public void add(int pos, T x) {
        validInsert(pos);

        // If no elements
        if (end == null) {
            this.start = this.end = new Node(x, null, null);
        }

        // If index = 0
        else if (pos == 0) {
            this.start = this.start.previous = new Node(x, this.start, null);
        }

        // If index = size
        else if (pos == size) {
            this.end = this.end.next = new Node(x, null, this.end);
        }

        // Any other place
        else {
            Node node = getNode(pos);
            node.previous = node.previous.next = new Node(x, node, node.previous);
        }

        size++;
    }

    @Override
    // Will add at the end
    public void add(T x) {
        add(this.size, x);
    }

    public void set(int pos, T x) {
        validGet(pos);
        this.getNode(pos).value = x;
    }

    public T get(int pos) {
        this.validGet(pos);
        return this.getNode(pos).value;
    }

    public T remove(int pos) {
        this.validGet(pos);
        Node node;

        // If one item in list
        if (size == 1) {
            node = this.start;
            this.start = this.end = null;
        }

        // First element
        else if (pos == 0) {
            node = this.start;
            this.start.next.previous = null;
            this.start = this.start.next;
        }

        // Last element
        else if (pos == size - 1) {
            node = this.end;
            this.end.previous.next = null;
            this.end = this.end.previous;
        }

        // Any other position
        else {
            node = this.get
        }

        size--;
        return node;
    }

    // Private methods
    private Node getNode(int pos) {
        validGet(pos);

        if (pos == 0) {
            return this.start;
        }

        else if (pos == size - 1) {
            return this.end;
        }

        if (pos < this.size * 0.5) {
            Node node = this.start;
            for (int i = 0; i < pos; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node node = this.end;
            for (int i = 0; i < size - pos - 1; i++) {
                node = node.previous;
            }
            return node;
        }
    }

    private void validInsert(int pos) {
        if (pos < 0 || pos > this.size) {
            throw new IllegalArgumentException("Insert: Not a valid index.");
        }
    }

    private void validGet(int pos) {
        if (pos < 0 || pos > this.size - 1) {
            throw new IllegalArgumentException("Get: Not a valid index.");
        }
    }
}