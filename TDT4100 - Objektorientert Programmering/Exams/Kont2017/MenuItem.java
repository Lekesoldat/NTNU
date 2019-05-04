public abstract class MenuItem {
  private final String name, description;
  
  public MenuItem(String name, String description) {
    this.name = name;
    this.description = description;
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }
}