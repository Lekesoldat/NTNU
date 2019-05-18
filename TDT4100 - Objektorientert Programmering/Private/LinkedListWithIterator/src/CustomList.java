import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public interface CustomList<T> extends Iterable<T> {
    int size();
    void add(int pos, T data);
    void add(T data);
    void setData(int pos, T data);
    T get(int pos);
    T remove(int pos);
    T remove();

    default Stream<T> stream() {
        return StreamSupport.stream(spliterator(), false);
    }
}
