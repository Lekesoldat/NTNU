import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Parent implements Relation {
  private List<Person> relatives = new ArrayList<>();

  @Override
  public Collection<Person> getRelativesOf(Person person) {
    if (person != null) {
      if (person.getFather() != null) {
        relatives.add(person.getFather());
      }

      if (person.getMother() != null) {
        relatives.add(person.getMother());
      }
    }
    return relatives;
  }
}