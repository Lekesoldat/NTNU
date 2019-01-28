public interface IList<T> {
    int size();
    void add(int pos, T x);
    void add(T x);
    void set(int pos, T x);
    T get(int pos);
    T remove(int pos);
    T remove();
}