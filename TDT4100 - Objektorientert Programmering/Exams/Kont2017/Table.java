import java.util.ArrayList;
import java.util.List;

/**
 * Manages the set of ordered items for a table (set of guests).
 */
public class Table implements KitchenListener {
  private List<MenuItem> items = new ArrayList<>();
  private Kitchen kitchen = null;
  
  private final Menu menu;

  /**
   * Initializes a new Table with a Menu that provides the prices for the Courses and Meals
   * @param menu
   */
  public Table(Menu menu) {
    this.menu = menu;
  }

  @Override
  public void courseReady(Table table, Course course) {
    // Do something
  }

  public void setKitchen(Kitchen k) {
    if (this.kitchen != null) {
      this.kitchen.removeKitchenListener(this);
    }

    this.kitchen = k;
    if (this.kitchen != null) {
      this.kitchen.addKitchenListener(this);
    }
  }

  public void addItem(MenuItem item) {
    if (!items.contains(item)) {
      items.add(item);
    }

    if (kitchen != null) {
      kitchen.menuItemAdded(this, item);
    }
  }
    /**
   * Computes the total price for all the added items. Prices are provided by the Menu.
   * @return the total price
   * @throws IllegalStateException when the price of an item cannot be provided by the Menu
   */
  public double getPrice() throws IllegalStateException {
    return items.stream().mapToDouble(this::grabPrice).sum();
  }

  public Double grabPrice(MenuItem item) {
    try {
      if (item instanceof Course) {
        return menu.getPrice((Course) item);
      }

      else if (item instanceof Meal) {
        return menu.getPrice((Meal) item);
      }

      throw new IllegalArgumentException("Illegal type");
    } catch (IllegalArgumentException e) {
      throw new IllegalStateException();
    }
  }
}