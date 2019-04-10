import java.util.Collection;

/**
 * A place where groups of guests can buy a meal
 */
public class Diner {

  public final Collection<Table> tables = new ArrayList<Table>();
  public final Collection<Seating> seatings = new ArrayList<Seating>();

  /**
   * Tells whether a Table is occupied.
   * 
   * @param table the Table to check
   * @return true if anyone is sitting at the provided Table
   */
  public boolean isOccupied(Table table) {
    return seatings.stream().anyMatch(x -> x.getTable() == table);
  }

  /**
   * Computes the guest capacity, either the remaining (includeOccupied == false)
   * or total (includeOccupied == true).
   * 
   * @param includeOccupied controls whether to include tables that are occupied.
   * @return the guest capacity
   */
  public int getCapacity(boolean includeOccupied) {
    // Create the stream.
    Stream<Table> stream = tables.stream();

    // If not including occupied tables, filter them away
    if (!includeOccupied) {
      stream = stream.filter(t -> !isOccupied(t));
    }

    return stream.mapToInt(Table::getCapacity).sum();
  }

  /**
   * Adds a table to this Diner
   * 
   * @param table
   */
  public void addTable(Table table) {
    tables.add(table);
  }

  /**
   * Removes a Table from this Diner. If the table is occupied an
   * IllegalArgumentException exception should be thrown.
   * 
   * @param table
   * @throws IllegalArgumentException
   */
  public void removeTable(Table table) {
    if (isOccupied(table)) {
      throw new IllegalArgumentException("Cannot remove occupied table.");
    }
    tables.remove(table);
  }

  /**
   * Merges two tables, i.e. replaces two tables with one table. lostCapacity is
   * the difference between the old capacity and the new. This number is typically
   * positive, since seats are lost when moving two tables close to each other.
   * 
   * @param table1
   * @param table2
   * @param lostCapacity
   * @throws IllegalArgumentException if any of the tables are occupied
   */
  public void mergeTables(Table table1, Table table2, int lostCapacity) {
    // Check occupation
    if (isOccupied(table1) || isOccupied(table2)) {
      throw new IllegalArgumentException("Table is occupied.");
    }

    tables.add(new CompositeTable(table1, table2, lostCapacity));
    tables.remove(table1);
    tables.remove(table2);
  }

  /**
   * Splits a table into two, i.e. replaces one tables with two tables. The two
   * capacities are the capacities of the two new tables.
   * 
   * @param table
   * @param capacity1
   * @param capacity2
   * @throws IllegalArgumentException if the table is occupied
   */
  public void splitTable(CompositeTable table) {
    if (isOccupied(table)) {
      throw new IllegalArgumentException("Table is occupied.");
    }

    tables.remove(table);
    tables.add(new Table(table.getTable1()));
    tables.add(new Table(table.getTable2()));
  }

  /**
   * Tells whether a table has the provided capacity, i.e. if that number of new
   * guests can be seated there. Note that a table cannot be shared among
   * different groups.
   * 
   * @param table
   * @param capacity
   * @return true of capacity number of guests can be seated here, false
   *         otherwise.
   */
  public boolean hasCapacity(Table table, int capacity) {
    return (!isOccupied(table) && table.getCapacity() >= capacity);
  }

  /**
   * Returns the tables that has the provided capacity. The tables should be
   * sorted with the one with the least capacity (but enough) first.
   * 
   * @param capacity
   * @return the tables that has the provided capacity
   */
  public Collection<Table> findAvailableTables(int capacity) {
    Collection<Table> tmp = new ArrayList<>();

    for (Table t : tables) {
      if (hasCapacity(t, capacity)) {
        tmp.add(t);
      }
    }
    Collections.sort(tmp);
    return tmp;
  }

  /**
   * Finds a suitable, existing table for the provided group, and creates (but
   * doesn't add) a corresponding Seating. The chosen table should be the one with
   * the least capacity.
   * 
   * @param group the group to be seated
   * @return the newly created Seating
   */
  public Seating createSeating(Group group) {
    Collection<Table> availableTables = findAvailableTables(group.getGuestCount());
    return (!availableTables.isEmpty() ? new Seating(availableTables.iterator().next(), group) : null);
  }

  /**
   * Creates and adds a Seating for the provided group, using the createSeating
   * method.
   * 
   * @param group
   * @return true if a Seating was created and added, false otherwise.
   */
  public boolean addSeating(Group group) {
    Seating seating = new Seating(group);
    if (seating != null) {
      seatings.add(seating);
      return true;
    }

    return false;
  }

  /**
   * Removes the seating for the provided table (number), if one exists
   * 
   * @param tableNum the number of the table to be removed
   */
  public void removeSeating(int tableNum) {
    for (Seating s : seatings) {
      if (s.getTable().getNum() == tableNum) {
        seatings.remove(s);
        return;
      }
    }
  }
}