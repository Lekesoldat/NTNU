/**
 * Represents the fact that a Group is seated at and occupies a Table
 */
public class Seating {
  private final Group group;
  private final Table table;

  /**
   * Initializes this Seating ...
   */
  public Seating(Table table, Group group) {
    // Early return
    if (table.getCapacity() < group.getGuestCount()) {
      throw new IllegalArgumentException("Not enough seats.");
    }

    this.table = table;
    this.group = group;
  }

  public Group getGroup() {
    return this.group;
  }

  public Table getTable() {
    return this.table;
  }
}