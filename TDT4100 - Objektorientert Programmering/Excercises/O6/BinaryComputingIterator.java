import java.util.Iterator;
import java.util.function.BinaryOperator;
import java.util.Arrays;

public class BinaryComputingIterator implements Iterator<Double> {
  private Iterator<Double> it1, it2;
  private Double default1, default2;
  private BinaryOperator<Double> operator;

  public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, Double default1, Double default2, BinaryOperator<Double> operator) {
    this.it1 = iterator1;
    this.it2 = iterator2;
    this.default1 = default1;
    this.default2 = default2;
    this.operator = operator;
  }

  public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, BinaryOperator<Double> operator) {
    this(iterator1, iterator2, null, null, operator);
  }

  @Override
  public boolean hasNext() {
    return (
      // Either next or default
      (it1.hasNext() || default1 != null)
      &&
      // Either next or default
      (it2.hasNext() || default2 != null)
      &&
      // To not use two defaults
      (it1.hasNext() || it2.hasNext())
    );
  }

  @Override
  public Double next() {
    Double next1 = (it1.hasNext() ? it1.next() : default1);
    Double next2 = (it2.hasNext() ? it2.next() : default2);
    return operator.apply(next1, next2);
  }

  public static void main(String[] args) {
    Iterator<Double> it1 = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0).iterator();
    Iterator<Double> it2 = Arrays.asList(3.0, 2.0, 1.0).iterator();
    BinaryComputingIterator bci = new BinaryComputingIterator(it1, it2, 15.0, 10.0, (a, b) -> a+b);

    System.out.println("Bci.hasNext(): " + bci.hasNext()); // Should be true
    System.out.println("Bci.next(): " + bci.next()); // Should be 4.0

    System.out.println("Bci.hasNext(): " + bci.hasNext()); // Should be true
    System.out.println("Bci.next(): " + bci.next()); // Should be 4.0

    System.out.println("Bci.hasNext(): " + bci.hasNext()); // Should be true
    System.out.println("Bci.next(): " + bci.next()); // Should be 4.0

    System.out.println("Bci.hasNext(): " + bci.hasNext()); // Should be true
    System.out.println("Bci.next(): " + bci.next()); // Should be 14.0

    System.out.println("Bci.hasNext(): " + bci.hasNext()); // Should be true
    System.out.println("Bci.next(): " + bci.next()); // Should be 15.0

    System.out.println("Bci.hasNext(): " + bci.hasNext()); // Should be false
    System.out.println("Bci.next(): " + bci.next()); // Should be 25.0
  }
}