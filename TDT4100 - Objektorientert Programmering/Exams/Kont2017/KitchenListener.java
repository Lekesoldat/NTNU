/**
 * Interface for classes that want to know when Courses have been produced by a Kitchen.
 */
public interface KitchenListener {
  public void courseReady(Table table, Course course);
}