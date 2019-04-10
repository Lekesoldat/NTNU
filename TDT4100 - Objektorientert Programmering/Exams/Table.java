/**
 * A table with a certain maximum capacity.
 */
public class Table {
  private static int tableCounter = 1;
  private final int tableNumber;

  private final int capacity;

  /**
   * Initializes this Table with the provided capacity. The table is also assigned
   * a unique number.
   * 
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

  public int getCapacity() {
    return this.capacity;
  }
}