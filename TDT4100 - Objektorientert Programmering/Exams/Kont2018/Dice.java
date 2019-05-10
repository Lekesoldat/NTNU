import java.util.Iterator;

/**
 * Represents a set of die values.
 */
public class Dice implements Iterable<Integer> {
  /**
   * Counters for each possible die value.
   * The counter at index i (0-5) is the counter for the die value i+1 (1-6).
   * I.e. the value at index 2 is the counter for die value 3.
   */
  private final int[] valueCounters;

  /**
   * Initializes this Dice with the values in dieValues.
   * @param dieValues sequence of die values, not counter values
   */
  public Dice(Iterator<Integer> dieValues) {
      this.valueCounters = new int[6];
      while (dieValues.hasNext()) {
        int dieValue = dieValues.next();

        if (dieValue > 6 || dieValue < 1) {
          throw new IllegalArgumentException("Not a valid die number");
        }

        valueCounters[dieValue - 1]++;
      }
  }

  /**
   * Invokes the constructor above.
   * Initializes this Dice with the values in dieValues.
   * @param dieValues sequence of die values, not counter values
   */
  public Dice(Iterable<Integer> dieValues) {
    this(dieValues.iterator());
  }

  @Override
  public Iterator<Integer> iterator() {
      return new DiceIterator(this);
  }

  /**
   * @return the number of die values
   */
  public int getDieCount() {
    int total = 0;
    for (int val : valueCounters) {
      total += val;
    }
    return total;
  }

  /**
   *
   * Die values are considered ordered, with the smallest die values at the lowest index. The value at a specific index must be computed from the counters in valueCounters.
   * @param dieNum
   * @return the value of die number dieNum
   * @throws an appropriate exception, if dieNum is out of range
   */
  public int getDieValue(int dieNum) {
    // Calculate what value die number dieNum had.
    if (dieNum < 0 || dieNum >= getDieCount()) {
      throw new IllegalArgumentException(dieNum + " out of range");
    }

    for (int dieValue = 1; dieValue <= 6; dieValue++) {
      int timesRolled = valueCounters[dieValue - 1];

      if (dieNum < timesRolled) {
        return dieValue;
      }

      dieNum -= timesRolled;
    }

    throw new IllegalArgumentException("Something went wrong here");
  }

  /**
     * @param value
     * @return the number of dice with the provided value
     */
    public int getValueCount(int value) {
      return this.valueCounters[value - 1];  
  }

  /**
   * @param dice
   * @return true if all die values in the Dice argument appear in this Dice
   */
  public boolean contains(Dice dice) {
    for (int i )
  }

  /**
   * @param dice
   * @return true if this Dice and the one provided have exactly the same die values
   */
  public boolean isSame(Dice dice) {
      ???
  }

  /**
   * @param dice a Dice object
   * @return a new Dice instance with the all the die values in
   * this Dice and the Dice argument combined
   */
  public Dice add(Dice dice) {
      ???
  }

  /**
   * @param dice
   * @return a new Dice instance with the die values from this Dice, but
   * without those from the Dice argument
   */
  public Dice remove(Dice dice) {
      ???
  }
}
