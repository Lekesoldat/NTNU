import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A place where groups of guests can buy a meal
 */
public class Diner {
  private Collection<Table> tables = new ArrayList<>();
  private Collection<Seating> seatings = new ArrayList<>();

  /**
  * Tells whether a Table is occupied.
  * @param table the Table to check
  * @return true if anyone is sitting at the provided Table
  */
  public boolean isOccupied(Table table) {
    return seatings.stream().anyMatch(s -> s.getTable() == table);
  }
  
  /**
  * Computes the guest capacity,
   * either the remaining (includeOccupied == false) or total (includeOccupied == true).
  * @param includeOccupied controls whether to include tables that are occupied.
  * @return the guest capacity
  */
  public int getCapacity(boolean includeOccupied) {
    Stream<Table> stream = tables.stream();

    if (includeOccupied) {
      return stream.mapToInt(Table::getCapacity).sum();
    }

    return stream.filter(t -> isOccupied(t)).mapToInt(Table::getCapacity).sum();
  }
  
  /**
  * Adds a table to this Diner
  * @param table
  */
  public void addTable(Table table) {
    if (!tables.contains(table)) {
      this.tables.add(table);
      fireCapacityChanged();
    }
  }

  /**
  * Removes a Table from this Diner.
  * If the table is occupied an IllegalArgumentException exception should be thrown.
  * @param table
  * @throws IllegalArgumentException
  */
  public void removeTable(Table table) {
    if (isOccupied(table)) {
      throw new IllegalArgumentException("Cannot remove occupied table.");
    }

    tables.remove(table);
    fireCapacityChanged();
  }
  
  /**
  * Merges two tables, i.e. replaces two tables with one table.
  * lostCapacity is the difference between the old capacity and the new.
  * This number is typically positive, since seats are lost when moving two tables
   * close to each other.
  * @param table1
  * @param table2
  * @param lostCapacity
  * @throws IllegalArgumentException if any of the tables are occupied
  */
  public void mergeTables(Table table1, Table table2, int lostCapacity) {
    if (isOccupied(table1) || isOccupied(table2)) {
      throw new IllegalArgumentException("Table is occupied");
    }

    removeTable(table1);
    removeTable(table2);
    addTable(new CompositeTable(table1, table2, lostCapacity));
  }

  /**
  * Splits a table into two, i.e. replaces one tables with two tables.
  * The two capacities are the capacities of the two new tables.
  * @param table
  * @throws IllegalArgumentException if the table is occupied
  */
  public void splitTable(CompositeTable table) {
    if (isOccupied(table)) {
      throw new IllegalArgumentException("Table is occupied");
    }
    removeTable(table);
    addTable(table.getTable1());
    addTable(table.getTable2());
  }

  /**
  * Tells whether a table has the provided capacity,
  * i.e. if that number of new guests can be seated there.
  * Note that a table cannot be shared among different groups.
  * @param table
  * @param capacity
  * @return true of capacity number of guests can be seated here, false otherwise.
  */
  public boolean hasCapacity(Table table, int capacity) {
    return (!isOccupied(table) && table.getCapacity() >= capacity);
  }

  /**
  * Returns the tables that has the provided capacity.
  * The tables should be sorted with the one with the least capacity (but enough) first.
  * @param capacity
  * @return the tables that has the provided capacity
  */
  public Collection<Table> findAvailableTables(int capacity) {
      return tables
        .stream()
        .filter(t -> hasCapacity(t, capacity))
        .sorted(((t1, t2) -> t1.getCapacity() - t2.getCapacity()))
        .collect(Collectors.toList());
  }
  
  /**
  * Finds a suitable, existing table for the provided group, and creates
  * (but doesn't add) a corresponding Seatindg.
  * The chosen table should be the one with the least capacity.
  * @param group the group to be seated
  * @return the newly created Seating
  */
  public Seating createSeating(Group group) {
    Collection<Table> tables = findAvailableTables(group.getGuestCount());
    if (tables.isEmpty()) {
      return null;
    }

    return new Seating(tables.iterator().next(), group);
  }
  
  /**
  * Creates and adds a Seating for the provided group, using the createSeating method.
  * @param group
  * @return true if a Seating was created and added, false otherwise.
  */

  public boolean addSeating(Group group) {
    Seating seating = createSeating(group);

    if (seating != null) {
      seatings.add(seating);
    }

    fireCapacityChanged();
    return seating != null;
  }
  
  /**
  * Removes the seating for the provided table (number), if one exists
  * @param tableNum the number of the table to be removed
  */
  public void removeSeating(int tableNum) {
    seatings.removeIf(t -> t.getTable().getNum() == tableNum);
    fireCapacityChanged();
  }


  public Collection<CapacityListener> listeners = new ArrayList<>();

  public void addCapacityListener(CapacityListener listener) {
    listeners.add(listener);
  }

  public void removeCapacityListener(CapacityListener listener) {
    listeners.remove(listener);
  }

  public void fireCapacityChanged() {
    listeners.forEach(l -> l.capacityChanged(this));
  }

  public static void main(String[] args) {
    Diner diner = new Diner();
    diner.addTable(new Table(5));
    diner.addTable(new Table(2));
    diner.addTable(new Table(7));
    diner.addTable(new Table(10));

    System.out.println(diner.findAvailableTables(6));
  }
}