public class Seating {
  private Table table;
  private Group group;

  public Seating(Table table, Group group) {
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