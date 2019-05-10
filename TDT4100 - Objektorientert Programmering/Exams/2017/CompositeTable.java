/**
 * A table that consists of two other tables.
 */
public class CompositeTable extends Table {
  private Table table1;
  private Table table2;
  
  public CompositeTable(Table table1, Table table2, int lostCapacity) {
         super(table1.getCapacity() + table2.getCapacity() - lostCapacity);
         this.table1 = table1;
         this.table2 = table2;
  }

  public Table getTable1() {
         return table1;
  }

  public Table getTable2() {
         return table2;
  }
}