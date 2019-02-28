package Midtsemesterforelesning;
import java.util.List;

public class Person {
  private Location location;
  public List<Dog> dogs;

  public Person() {
    this.location = new Location(0, 0, 10, 10);
  }
}