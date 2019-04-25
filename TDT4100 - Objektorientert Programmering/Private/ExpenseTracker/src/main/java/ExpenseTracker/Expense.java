package ExpenseTracker;

public class Expense {
  private static int idCounter = 0;

  private final int expenseID;
  private String title = "";
  private String description = "";
  private Double price;

  public Expense(String title, Double price, String description) {
    this.title = title;
    this.price = price;
    this.description = description;

    this.expenseID = idCounter++;
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @return the price
   */
  public Double getPrice() {
    return price;
  }

  public String getPriceAsString() {
    return price.toString();
  }

  /**
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * @return the ExpenseID
   */
  public int getExpenseID() {
    return expenseID;
  }

  @Override
  public String toString() {
    return new StringBuilder()
      .append("ID: " + this.expenseID)
      .append("\nTitle: " + this.title)
      .append("\nPrice: " + this.price)
      .append("\nDescription: " + this.description)
      .toString();
  }
}