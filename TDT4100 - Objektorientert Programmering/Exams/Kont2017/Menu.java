import java.util.HashMap;

/**
 * Manages the set of Courses and Meals offered and their prices.
 */
public class Menu {

  public HashMap<MenuItem, Double> menuItems = new HashMap<>();
  
  /**
   * Gets the price for a Course.
   * @param course
   * @return the price
   * @throws IllegalArgumentException if this Menu doesn't include the provided Course
   */
  public double getPrice(Course course) throws IllegalArgumentException {
    if (!menuItems.containsKey(course)) {
      throw new IllegalArgumentException(course.getName() + " is not a part of this menu.");
    }

    return menuItems.get(course);
  }

  /**
   * Sets/changes the price of the provided Course.
   * @param course
   * @param price
   */
  public void updatePrice(MenuItem item, double price) {
    menuItems.put(item, price);
  }
   
  /**
   * Gets the price for a Meal. If the registered price is 0.0,
   * the price is computed as the sum of the prices of the Meal's courses.
   * @param meal
   * @return
   * @throws IllegalArgumentException if this Menu doesn't include the provided Meal,
   *  or if a price of a Course is needed, but is missing
   */
  public double getPrice(Meal meal) throws IllegalArgumentException {
    if (!menuItems.containsKey(meal)) {
      throw new IllegalArgumentException("Meal not in this menu");
    }

    double total = menuItems.get(meal);
    if (total == 0.0) {
      for (Course c : meal) {
        total += getPrice(c);
      }
    }

    return total;
  }   

  /**
   * Sets/changes the price of the provided Meal.
   * @param meal
   * @param price
   */
  public void updatePrice(Meal meal, double price) {
    menuItems.put(meal, price);
  }
}