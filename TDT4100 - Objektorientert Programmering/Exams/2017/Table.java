/**
 * A table with a certain maximum capacity.
 */
public class Table {
  private static int tableCounter = 1;

  private int tableNumber;
  private int capacity = 0;

  /**
  * Initializes this Table with the provided capacity.
  * The table is also assigned a unique number.
  * @param capacity
  */
  public Table(int capacity) {
    this.capacity = capacity;
    this.tableNumber = tableCounter++;
  }

  /**
  * @return the table number
  */
  public int getNum() {
    return this.tableNumber;
  }

  /**
   * @return the capacity
   */
  public int getCapacity() {
    return capacity;
  }

  @Override
  public String toString() {
    return new StringBuilder()
      .append("Num: " + this.tableNumber)
      .append("\nCap: " + this.capacity)
      .toString();
  }
}