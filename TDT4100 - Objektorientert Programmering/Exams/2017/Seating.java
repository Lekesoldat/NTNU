public class Seating {
  private Table table;
  private Group group;

  public Seating(Table table, Group group) {
    if (group.getGuestCount() > table.getCapacity()) {
      throw new IllegalArgumentException("Cannot fit guests.");
    }

    this.table = table;
    this.group = group;
  }

  public Table getTable() {
    return this.table;
  }

  public Group getGroup() {
    return this.group;
  }

}