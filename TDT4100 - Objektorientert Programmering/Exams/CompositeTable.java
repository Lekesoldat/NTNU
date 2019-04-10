public class CompositeTable extends Table {
  public final Table table1, table2;
  public final int lostCapacity;

  public CompositeTable(Table one, Table two, int lostCapacity) {
    super(new Table(one.getCapacity() + two.getCapacity() - lostCapacity));
    this.table1 = one;
    this.table2 = two;
    this.lostCapacity = lostCapacity;
  }

  public Table getTable1() {
    return this.table1;
  }

  public Table getTable2() {
    return this.table2;
  }
}