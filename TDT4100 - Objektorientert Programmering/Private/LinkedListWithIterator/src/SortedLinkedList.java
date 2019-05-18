public class SortedLinkedList<T extends Comparable<T>> extends LinkedList<T> {
    @Override
    public void add(T data) {
        Node<T> node = this.head;

        for (int i = 0; i < size(); i++) {
            if (node.getData().compareTo(data) > 0) {
                super.add(i, data);
                return;
            }
            node = node.getNext();
        }
        super.add(size(), data);
    }

    @Override
    public T remove() {
        return remove(size() - 1);
    }

    @Override
    public void add(int pos, T data) {
        throw new UnsupportedOperationException("Cannot add on position in a sorted list");
    }

    @Override
    public void setData(int pos, T data) {
        throw new UnsupportedOperationException("Cannot set data without sorting all over.");
    }
}
