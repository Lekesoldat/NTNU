public class Stack<T> extends LinkedList<T> {
    public T pop() {
        return remove(size() - 1);
    }

    public void push(T data) {
        add(data);
    }
}
